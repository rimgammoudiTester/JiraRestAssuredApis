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
/*pipeline {
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
}*/
pipeline {
    agent any // On utilise l'agent Jenkins local pour éviter les bugs de montage automatique

    stages {
        stage('Checkout') {
            steps {
                // Récupère votre projet JiraRestAssuredApis
                checkout scm
            }
        }

        stage('Run Tests in Docker') {
            steps {
                echo 'Démarrage des tests dans le conteneur Maven...'

                /* Explications de la commande :
                   -v "%WORKSPACE%":/app -> Monte votre code source dans le dossier /app du conteneur
                   -w /app -> Définit le répertoire de travail dans le conteneur
                   mvn clean test... -> Exécute vos tests TestNG
                */
                bat "docker run --rm -v \"%WORKSPACE%\":/app -w /app maven:3.9.0-eclipse-temurin-17 mvn clean test -Dtest=jqlApiTestCases"
            }
        }
    }

    post {
        always {
            echo 'Archivage des résultats de tests...'
            // Récupère les rapports XML générés pour les afficher dans l'interface Jenkins
            junit '**/target/surefire-reports/*.xml'
        }
        success {
            echo 'Félicitations Rim ! Le pipeline a réussi.'
        }
        failure {
            echo 'Le pipeline a échoué. Vérifiez les logs Docker ci-dessus.'
        }
    }
}