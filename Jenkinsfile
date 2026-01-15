pipeline {
    agent any

    stages {

        stage('Checkout Code') {
            steps {
                checkout scm
            }
        }

        stage('Maven Build') {
            steps {
                sh 'mvn clean package'
            }
        }

        stage('Docker Build') {
            steps {
                sh 'docker build -t muneer/java-devops-app:latest .'
            }
        }

        stage('Run Container') {
            steps {
                sh '''
                docker rm -f java-app || true
                docker run -d -p 8081:8080 --name java-app muneer/java-devops-app:latest
                '''
            }
        }
    }
}

