pipeline {
    agent none
    environment {
      ORG               = 'zefiber25'
      APP_NAME          = 'ze1'
    }
    stages {
		  stage('K8s Deploy') {
		      agent any
		      steps {
			    container('kubectl') {
				    sh "kubectl --namespace=jx delete deployment ze1-deployment"
					sh "kubectl --namespace=jx delete service ze1-service"
					sh "kubectl --namespace=jx create -f ze1-deployment.yaml"
					sh "kubectl --namespace=jx set image deployment/ze1-deployment ze1=zefiber/ze1:0.0.18"
				}
				
			  }
          }
		  
  }
  
}
