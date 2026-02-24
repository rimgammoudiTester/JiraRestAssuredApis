pipeline{
agent
docker {
image 'Apache Maven 3.9.0'
}
tools{
maven "maventest"}

stages{

stage('Build')
{
steps{
bat "mvn clean"
}

}

stage('Test')
{
steps{
bat 'mvn test -DsuiteXmlFile=suites/suites.xml'
}
}

}

}