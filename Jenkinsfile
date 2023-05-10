pipeline {
    agent any

    stages {
        stage('Clean') {
            steps {
                echo 'Building..'
                sh "mvn clean -Dbrowser=localchrome"
            }
        }
        stage('Build') {
            steps {
                echo 'Versioning..'
                sh "mvn clean -X -Dbrowser=localchrome"
            }
        }
        stage('Test') {
            steps {
                echo 'Testing..'
                sh "mvn clean install test -Dbrowser=localchrome"
            }
        }

        stage('Publish Report') {
            steps {
                publishHTML([allowMissing: false, alwaysLinkToLastBuild: true, keepAll: true, reportDir: '', reportFiles: 'target/test-output/ExtentReport.html', reportName: 'HTML Report', reportTitles: 'Pipeline', useWrapperFileDirectly: true])
            }
        }
        //stage('Deploy') {
          //  steps {
            //    echo 'Deploying....'
              //  sh "mvn clean package -Dbrowser=chrome"
            //}
        //}
    }
}