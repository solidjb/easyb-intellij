export IDEA="$HOME/Applications/IntelliJ IDEA 10.app"
export IDEA_VERSION=10.0
mvn install:install-file -Dfile="$IDEA/lib/annotations.jar" -DgroupId=com.intellij.idea -DartifactId=annotations -Dversion=$IDEA_VERSION -Dpackaging=jar
mvn install:install-file -Dfile="$IDEA/lib/idea.jar" -DgroupId=com.intellij.idea -DartifactId=idea -Dpackaging=jar -DgeneratePom=true -DcreateChecksum=true -Dversion=$IDEA_VERSION
mvn install:install-file -Dfile="$IDEA/lib/openapi.jar" -DgroupId=com.intellij.idea -DartifactId=openapi -Dpackaging=jar -DgeneratePom=true -DcreateChecksum=true -Dversion=$IDEA_VERSION
mvn install:install-file -Dfile="$IDEA/lib/util.jar" -DgroupId=com.intellij.idea -DartifactId=util -Dpackaging=jar -DgeneratePom=true -DcreateChecksum=true -Dversion=$IDEA_VERSION
mvn install:install-file -Dfile="$IDEA/lib/extensions.jar" -DgroupId=com.intellij.idea -DartifactId=extensions -Dpackaging=jar -DgeneratePom=true -DcreateChecksum=true -Dversion=$IDEA_VERSION
mvn install:install-file -Dfile="$IDEA/plugins/Groovy/lib/Groovy.jar" -DgroupId=com.intellij.idea -DartifactId=Groovy -Dpackaging=jar -DgeneratePom=true -DcreateChecksum=true -Dversion=$IDEA_VERSION