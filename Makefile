run:
	docker-compose up --detach &&
ebs_login_build:
	mvn package -f EBS-Login/pom.xml -DskipTests=true && docker-compose up --detach
stop:
	docker-compose down
