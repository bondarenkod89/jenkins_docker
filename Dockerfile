FROM jenkins/jenkins:lts

ENV CASC_JENKINS_CONFIG=/var/jenkins_home/casc_configs/jenkins.yaml

COPY plugins.txt /usr/share/jenkins/ref/plugins.txt
COPY jenkins.yaml /var/jenkins_home/casc_configs/jenkins.yaml

COPY property1.txt /usr/share/jenkins/ref/property1.txt
COPY property2.txt /usr/share/jenkins/ref/property2.txt

RUN /usr/local/bin/install-plugins.sh < /usr/share/jenkins/ref/plugins.txt
