pipeline{
agent any
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
bat 'mvn test -Dtest=JiraAutomationPackage.JiraApiTests.Users.UsersApiTests'
}
}

}

}