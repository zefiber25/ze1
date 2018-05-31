pipeline {
    agent {
      label "jenkins-maven"
    }
    environment {
      ORG               = 'zefiber25'
      APP_NAME          = 'ze1'
    }
    stages {
	      stage('Maven Install') {
	      agent {
	        docker {
	          image 'maven:3.5.0'
	        }
	      }
	      steps {
	        sh 'mvn clean install'
	      }
	    }
      }
      
    post {
        always {
            cleanWs()
        }
        failure {
            input """Pipeline failed. 
We will keep the build pod around to help you diagnose any failures. 

Select Proceed or Abort to terminate the build pod"""
        }
    }
  }
