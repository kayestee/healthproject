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
        echo "Testing"
      }
    }

    stage('deploy') {
      steps {
        echo "Deploying"
      }
    }

  }
}
