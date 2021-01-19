# Lab 3

Third lab is about using the power of Kubernetes to deploy without any downtime:
* update the version of nginx used
* use rollout to deploy to the first version
* check the history of the rollout

## Update the version of nginx used

> :warning: Be sure to deploy `www` first.

There is two way to update the deployment:
```shell
kubectl set image deployments/www nginx=nginx:1.17 --record
```

and

```shell
kubectl edit deployments www --record
```

## Use Rollout to deploy another version of nginx

We can simply rollout with:
```shell
kubectl rollout undo deployments/www
```

We should use `nginx` image with tag `1.17` if we have edited twice the deployment.
```shell
kubectl get deployments www -o yaml | grep "image:"
```

## Check the history of the rollout

Checking the history is simple enough:
```shell
kubectl rollout history deployments www
```

and from this point, rollout to a specific `revision`:
```shell
kubectl rollout undo deployments www --to-revision=1
```

