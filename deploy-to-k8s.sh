#!/bin/bash
kubectl --namespace=jx delete deployment ze1-deployment
kubectl --namespace=jx delete service ze1-service
kubectl --namespace=jx create -f ze1-deployment.yaml
kubectl --namespace=jx set image deployment/ze1-deployment ze1=zefiber/ze1:0.0.18

#To get the service port from namespace=jx
#kubectl --namespace=jx get service