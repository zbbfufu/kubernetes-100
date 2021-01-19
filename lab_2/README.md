# Lab 2

Second lab objective is to deploy a proxy a manipulate it:
* deploy a nginx proxy
* check Deployment, Replicaset and Pod resource. Can you explain what you’re seeing ?
* scale up and down your nginx deployment
* delete the deployment. What do you expect ?

## Deploy a Nginx proxy

Declarative way:
```shell
kubectl create -f www.yaml
```

## Check Deployment, ReplicaSet and Pod

We can check the current cluster state of the deployment with the classic:
```shell
kubectl get deployments www -o yaml
```

Also for the ReplicaSet:
```shell
kubectl get replicaset www-*SUFFIX* -o yaml
```

Deployment, ReplicaSet and Pods are linked with labels! Creating a Deployment, also create the associated ReplicaSet and the Pod.

## Scale up and down

To scale up or down, simply do:
```shell
kubectl scale deployments www --replicas=10
```

## Delete the Deployment

We expect that Kubernetes deletes every linked resource to this deployment: `replicaset` and `pods`

