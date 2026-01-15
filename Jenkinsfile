pipeline {
    agent any

    environment {
        DOCKER_IMAGE = "myapp:latest"   // Docker image ka naam
        CONTAINER_NAME = "myapp_container" // Container ka naam
        HOST_PORT = "8081"               // Ye port aap browser me access karoge
        CONTAINER_PORT = "8081"          // Container ka port jo app use karta hai
    }

    stages {
        stage('Checkout Code') {
            steps {
                git 'https://github.com/username/your-java-app.git'
            }
        }

        stage('Build Docker Image') {
            steps {
                script {
                    sh "docker build -t ${DOCKER_IMAGE} ."
                }
            }
        }

        stage('Stop & Remove Old Container') {
            steps {
                script {
                    sh """
                    docker ps -a -q --filter name=${CONTAINER_NAME} | grep -q . && docker stop ${CONTAINER_NAME} && docker rm ${CONTAINER_NAME} || echo 'No old container found'
                    """
                }
            }
        }

        stage('Run Docker Container') {
            steps {
                script {
                    sh "docker run -d -p ${HOST_PORT}:${CONTAINER_PORT} --name ${CONTAINER_NAME} ${DOCKER_IMAGE}"
                }
            }
        }

        stage('Verify') {
            steps {
                script {
                    sh "curl -I http://localhost:${HOST_PORT}"
                }
            }
        }
    }
}

