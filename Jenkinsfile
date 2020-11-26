pipeline {
    agent  any
     parameters {
            choice(name: 'role', choices: ['ta', 'tu'], description: 'Pick which role should the tests run against')
    }
    tools {
        maven 'M3'
    }
    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/gregorysav/SeleniumWebDriver'
            }
        }
        stage('Build and Test') {
            steps {
                sh "mvn clean test -P${params.role}"
            }
        }
    }
    post {
        always {
            script {
                allure([
                    includeProperties: false,
                    jdk: '',
                    results: [[path: 'target/allure-results']]
                ])
            }
        }
    }
}