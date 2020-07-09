build_app:
	mvn package -f EBS-Login/pom.xml -DskipTests=true
run:
	make build_app && docker-compose build --no-cache && docker-compose up --detach
stop:
	docker-compose down