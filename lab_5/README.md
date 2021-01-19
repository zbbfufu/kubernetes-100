# Lab 5

We will now deploy a concrete Spring Boot applications and parametrize  the configuration by using:
* ConfigMap
* Secret
* Environment Variable

## ConfigMap

ConfigMap are very simple to use. Every key present in the ConfigMap will be mapped as `environment variable` to the pod.

Open up config-map.yaml to see what's inside.
```shell
cat config-map.yaml
```

Deploy it
```shell
kubectl create -f config-map.yaml
```

Deploy the Spring Boot application. ConfigMap has been set in the YAML already.
```shell
kubectl create -f app.yaml
```
Try to port-forward the pod and access the default controller `/hello`.

```shell
kubectl port-forward simple-hello 5000:8080
curl 127.0.0.1:5000/hello
```

Note the fact that the application is using an environment variable called `SPRING_USERNAME` which is injected through ConfigMap.

Now delete the deployment:
```shell
kubectl delete -f app.yaml
```



## Secret

Secrets works exactly the same as ConfigMap. The only difference is that by default, all fields are BASE64 encrypted.

> :warning: If let privileges as is, everyone could decode your secrets which is a huge security issue...


Deploy the secret:
```shell
kubectl create -f secret.yaml
```

Delete the pod if it still exists and launch:
```shell
kubectl create -f app-w-secret.yaml
```

Port-forward and access now `/secret`
```shell
kubectl port-forward simple-hello 5000:8080
curl 127.0.0.1:5000/secret
```

Congrats for going so far :)

