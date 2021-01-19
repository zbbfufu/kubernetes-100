# Introduction

This repository is meant to be used only for the one day Kubernetes Sfeir Institute.
Google slides are available [here](https://docs.google.com/presentation/d/1LS1AizY-rsizMgFnLJsSndkpMc9z6a1TO8HB9idkk7Y/edit?usp=sharing).

# Getting started

First connect on the [GCP console](https://console.cloud.google.com).

From "sfeir.cloud" organization, in the `k8s-20210119` project, open a Cloud Shell.

Configure `gcloud` to use the correct *PROJECT_ID*:
```shell
gcloud config set project k8s-20210119
```

Configure `.kube/config` to access the cluster:
```shell
gcloud container clusters get-credentials k8s-fundamentals --zone europe-west1-d --project k8s-20210119
```

Then enable auto-completion for Bash:
```shell
source <(kubectl completion bash) # setup autocomplete in bash into the current shell, bash-completion package should be installed first.
echo "source <(kubectl completion bash)" >> ~/.bashrc # add autocomplete permanently to your bash shell.
```

Finally, create your own namespace, based on your first name:
```shell
kubectl create namespace <firstname>
```

You're ready to go!
