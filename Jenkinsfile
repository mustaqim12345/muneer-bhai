pipeline {
    agent any

    environment {
        IMAGE_NAME = "myapp-image"
        CONTAINER_NAME = "myapp-container"
        PORT = "8081"
    }

    stages {
        stage('Checkout Code') {
            steps {
                git 'https://github.com/mustaqim12345/muneer-bhai.git'
            }
        }

        stage('Build Docker Image') {
            steps {
                script {
                    sh "docker build -t $IMAGE_NAME ."
                }
            }
        }

        stage('Run Docker Container') {
            steps {
                script {
                    // Agar pehle container chal raha hai to stop aur remove kar do
                    sh """
                    if [ \$(docker ps -a -q -f name=$CONTAINER_NAME) ]; then
                        docker stop $CONTAINER_NAME
                        docker rm $CONTAINER_NAME
                    fi
                    docker run -d --name $CONTAINER_NAME -p $PORT:$PORT $IMAGE_NAME
                    """
                }
            }
        }
    }

    post {
        success {
            echo "Docker container is up! Access it at http://<VM-IP>:$PORT"
        }
    }
}
