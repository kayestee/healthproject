pipeline {
  agent any
  stages {
    stage('build') {
      steps {
        sh 'docker-compose up'
      }
    }

    stage('test') {
      steps {
        sh ' echo "Testing"'
      }
    }

    stage('deploy') {
      steps {
        sh '''            echo "Deploying"
'''
      }
    }

  }
}