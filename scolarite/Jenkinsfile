pipeline {
    agent any
    
    stages {
        stage('Build') {
            steps {
                // Clean and build Maven project
                sh 'mvn clean install'
            }
        }
        
        stage('Test') {
            steps {
                // Run unit tests using Surefire Plugin
                sh 'mvn test'
            }
        }
        
        stage('Deploy') {
            steps {
                // Deploy Maven artifact (adjust this command based on your deployment needs)
                sh 'mvn deploy'
            }
        }
    }
}
