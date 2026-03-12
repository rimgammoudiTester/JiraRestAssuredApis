pipeline {
    agent any

    tools {
        // Assurez-vous que ce nom correspond au nom configuré dans
        // "Manage Jenkins" -> "Global Tool Configuration" -> "Maven"
        maven 'Maven_3.9'
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Run Tests') {
            steps {
                echo 'Exécution des tests en local sur l\'agent Jenkins...'
                // Sur Windows, on utilise 'bat', sur Linux/Mac on utilise 'sh'
                bat "mvn clean test -Dtest=jqlApiTestCases"
            }
        }
    }

    post {
        always {
            echo 'Archivage des résultats...'
            junit '**/target/surefire-reports/*.xml'
        }
        success {
            echo 'Félicitations Rim ! Le pipeline local a réussi.'
        }
        failure {
            echo 'Le pipeline a échoué. Corrigez les erreurs de compilation Java.'
        }
    }
}
