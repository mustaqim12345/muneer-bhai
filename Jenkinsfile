pipeline {
    agent any

    stages {

        stage('Git Clone') {
            steps {
                git 'https://github.com/mustaqim12345/muneer-bhai.git'
            }
        }

        stage('Maven Build') {
            steps {
                sh 'mvn clean package'
            }
        }

        stage('Docker Build') {
            steps {
                sh 'docker build -t java-devops-app .'
            }
        }

        stage('Run Container') {
            steps {
                sh '''
                docker stop java-app || true
                docker rm java-app || true
                docker run -d -p 8081:8080 --name java-app java-devops-app
                '''
            }
        }
    }
}

