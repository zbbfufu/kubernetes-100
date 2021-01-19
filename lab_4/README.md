# Lab 4

Fourth lab concerns exposing deployments/pods through services:
* create a ClusterIP service and access nginx
* create a NodePort service and access nginx
* create a LoadBalancer service and access nginx

## Create a ClusterIP service

> :warning: Be sure to deploy `www` first.

We can ask Kubernetes to expose a deployment in two ways.

Imperative way:
```shell
kubectl expose deployments www --port=80 --target-port=80
```

Declarative way:
```shell
kubectl create -f cluster-ip.yaml 
```

Test that exposing `nginx` works **ONLY** within the cluster!
```shell
kubectl run -i --tty busybox --image=busybox --restart=Never -- sh
wget *service-ip*:80
```

From the Cloud Shell, we shouldn't have any answer:
```shell
curl *service-ip*:80
```

## Create A NodePort service

Again, it is possible to do it with `kubectl` but we'll use the declarative way:
```shell
kubectl create -f node-port.yaml
```

Since the pods are deployed on *random* nodes, let's find the external IP of one server where `nginx` is deployed on:
```shell
kubectl describe pod *pod-name* | grep -i node
```

which will give us the `node` name. We can now find the external IP, thanks to `gcloud`

```shell
gcloud compute instances list
```

and then, from your browser, try to access http://*EXTERNAL_IP*:*SERVICE_PORT*

You've successfuly accessed your pod from the browser!

## Create a LoadBalancer service

`LoadBalancer` type is a special type that works really well with Cloud Providers. In GCP, in automatically provision a load balancer for us. Do:

```shell
kubectl create -f load-balancer.yaml
```

wait a little bit that the LB is provisionned and check for it's IP with:
```shell
kubectl get services
```

Use then IP of the LB and it's port to access your pods! Also, LB will manage the traffic for you. Do request with the cmd line.

```shell
while true; do curl http://*LB_IP*/; sleep 1; done
```

