pipeline{
agent {
docker {
image 'maven:3.9.0-eclipse-temurin-17'
}}
stages{

stage('Build')
{
steps{
sh "mvn clean"
}

}

stage('Test')
{
steps{
sh 'mvn clean test -Dtest=jqlApiTestCases'
}
}

}

}