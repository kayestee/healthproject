pipeline {
  agent any
  stages {
    stage('build') {
      steps {
        echo 'Building'
        dir(path: 'healthfront') {
          sh 'npm run build'
          dir(path: '..')
        }

        dir(path: 'healthcheck') {
          sh './gradlew build'
          dir(path: '../healthweb') {
            sh './gradlew build'
          }

        }

      }
    }

    stage('test') {
      steps {
        echo 'Testing'
      }
    }

    stage('deploy') {
      steps {
        echo 'Deploying'
      }
    }

  }
}