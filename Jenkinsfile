/*pipeline{
agent {
docker {
image 'maven:3.9.0-eclipse-temurin-17'
args '-v /var/run/docker.sock:/var/run/docker.sock'

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

}*/
pipeline {
    agent {
        docker {
            image 'maven:3.9.0-eclipse-temurin-17'
            // Cette option force Docker à ignorer le chemin Windows complexe
            args '-v /var/run/docker.sock:/var/run/docker.sock'
            // On définit un dossier de travail simple pour le conteneur
            customWorkspace '/maven-workspace'
        }
    }
    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }
        stage('Test Execution') {
            steps {
                // Important : Utilisez 'sh' car on est DANS le conteneur Linux maintenant
                sh 'mvn clean test -Dtest=jqlApiTestCases'
            }
        }
    }
}