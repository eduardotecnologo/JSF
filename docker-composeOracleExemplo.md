version: '3.8'

services:
  oracle-db:
    image: store/oracle/database-enterprise:12.2.0.1-slim
    container_name: oracle-db
    ports:
      - "1521:1521"
    environment:
      - ORACLE_SID=ORCLCDB
      - ORACLE_PDB=ORCLPDB1
      - ORACLE_PWD=YourPassword123
    volumes:
      - oracle-data:/opt/oracle/oradata
    healthcheck:
      test: ["CMD-SHELL", "echo 'SELECT 1 FROM dual;' | /opt/oracle/product/12.2.0.1/dbhome_1/bin/sqlplus system/YourPassword123@ORCLCDB"]
      interval: 1m
      timeout: 30s
      retries: 10

volumes:
  oracle-data:
