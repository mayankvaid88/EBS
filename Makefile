build_app:
	mvn package -f EBS-Login/pom.xml -DskipTests=true
run:
	make build_app && docker-compose build --no-cache && docker-compose up --detach --scale ebs_login_app=2
stop:
	docker-compose down