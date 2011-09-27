package dstywho.jdbc;

import java.util.ArrayList;
import java.util.Vector;

import org.apache.commons.lang.StringUtils;

public class QueryHelper {

	public void insert(String tableName, Row row) {
		ArrayList query = new ArrayList<String>();
		query.add("INSERT into " + tableName);
		query.add("(" + StringUtils.join(row.getColumns(), ", ") + ")");
		query.add("values");
		query.add("(" + StringUtils.join(row, ",") + ")");
		System.out.println(StringUtils.join(query, "\n"));
		insert(StringUtils.join(query, "\n"));
	}

	public Table query(String query) {
		Table results = null;
		QueryManager qm = new QueryManager();
		try {
			qm.startConnection();

			results = qm.query(query);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			qm.closeConnection();
		}
		return results;
	}

	public static void main(String[] args) {
		final String queryId = new QueryHelper().query("SELECT MAX(QUERY_ID) FROM CALGBTEST.QUERY").get(0).get(0);
		System.out.println(queryId);
		Row row = new Row() {
			{
				add(Integer.parseInt(queryId) + 1 + "");
				add("128");
				add("80303");
				add("580505");
				add("125");
				add("999");
				add("sysdate");
				add("34653");
				add("sysdate");
				setColumns(new Vector<String>() {
					{
						add("QUERY_ID");
						add("DATA_TYPE_ID");
						add("STUDY_NUM");
						add("PATIENT_ID");
						add("QUERY_TYPE_ID");
						add("QUERY_ID_NAME");
						add("CREATION_DT");
						add("OPERATOR_ID");
						add("OPERATOR_DT");
					}
				});

			}
		};
		new QueryHelper().insert("CALGBTEST.Query", row);
	}

	public void insert(String query) {
		QueryManager qm = new QueryManager();
		try {
			qm.startConnection();

			qm.update(query);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			qm.closeConnection();
		}
	}

}
