# Lab 6

Last but not least, we need to secure our cluster access and sensitive data like secrets:
* create 1 role that should be able to read, modify and delete secrets

## Prerequisite

We need to secure access to a secret, so we have to create one.

```shell
kubectl create -f secret.yaml
```

## Role creation

Create the role with permission needed.
```shell
kubectl create -f role-secret-full-right.yaml
```

In order to simulate other users, we will create two serviceaccount.
```shell
kubectl create -f first-sa.yaml
kubectl create -f second-sa.yaml
```

To finish, bind one serviceaccount to the newly defined role.
```shell
kubectl create -f rolebinding-secret-full-right.yaml
```

Try to access the Secret API with each one of those account and verify it's working as expected.
Each serviceaccount has a Secret associated which contain it's token.

> :warning: do not forget to decode the base64 before passing the token to kubectl

```shell
kubectl --token=*SA_TOKEN* get secrets
```

Noice!
