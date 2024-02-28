pipeline {
    agent any
    
    stages {
        stage('Build') {
            steps {
                // Clean and build Maven project
                bat 'mvn clean install'
            }
        }
        
        stage('Test') {
            steps {
                // Run unit tests using Surefire Plugin
                bat 'mvn test'
            }
        }
        
        stage('Deploy') {
            steps {
                // Deploy Maven artifact (adjust this command based on your deployment needs)
                bat 'mvn deploy'
            }
        }
    }
}
