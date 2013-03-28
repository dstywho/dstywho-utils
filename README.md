
Hosting Maven repo on Github
---------------------------
    mvn -DaltDeploymentRepository=snapshot-repo::default::file:/tmp/repo clean deploy
    cp  /tmp/repo/dustin-utils/dustin-utils snapshots


In pom.xml
-----------
    <repositories>
    <repository>
        <id>dstywho-utils</id>
        <url>https://raw.github.com/dstywho/dstywho-utils/mvn-repo/snapshots</url>
    </repository>
    </repositories>

