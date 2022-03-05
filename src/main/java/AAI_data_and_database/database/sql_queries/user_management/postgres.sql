CREATE USER dbread WITH PASSWORD 'FFZ4GX8lb6Oa1E';


--first grant access to 'PROD-Environment' (DATABASE = postgres)
GRANT CONNECT ON DATABASE postgres TO dbread;

--then grant access to single DBs. For this, open new query tool for each DB

--camiuns_errorhandling_db
GRANT CONNECT ON DATABASE camiuns_errorhandling_db TO dbread;
GRANT USAGE ON SCHEMA public TO dbread;
GRANT SELECT ON ALL TABLES IN SCHEMA public TO dbread;

--camiuns_iks_db
GRANT CONNECT ON DATABASE camiuns_iks_db TO dbread;
GRANT USAGE ON SCHEMA public TO dbread;
GRANT SELECT ON ALL TABLES IN SCHEMA public TO dbread;

--camiuns_monitoring_db_prod
GRANT CONNECT ON DATABASE camiuns_monitoring_db_prod TO dbread;
GRANT USAGE ON SCHEMA public TO dbread;
GRANT SELECT ON ALL TABLES IN SCHEMA public TO dbread;

--camiuns_refund_db
GRANT CONNECT ON DATABASE camiuns_refund_db TO dbread;
GRANT USAGE ON SCHEMA public TO dbread;
GRANT SELECT ON ALL TABLES IN SCHEMA public TO dbread;

--camiuns_vehicledata_db_prod
GRANT CONNECT ON DATABASE camiuns_vehicledata_db_prod TO dbread;
GRANT USAGE ON SCHEMA public TO dbread;
GRANT SELECT ON ALL TABLES IN SCHEMA public TO dbread;

--declaration_complement_db_prod
GRANT CONNECT ON DATABASE declaration_complement_db_prod TO dbread;
GRANT USAGE ON SCHEMA public TO dbread;
GRANT SELECT ON ALL TABLES IN SCHEMA public TO dbread;

--eets_assessment_db
GRANT CONNECT ON DATABASE eets_assessment_db TO dbread;
GRANT USAGE ON SCHEMA public TO dbread;
GRANT SELECT ON ALL TABLES IN SCHEMA public TO dbread;

--eets_billing_db
GRANT CONNECT ON DATABASE eets_billing_db TO dbread;
GRANT USAGE ON SCHEMA public TO dbread;
GRANT SELECT ON ALL TABLES IN SCHEMA public TO dbread;

--eets_blacklist_db
GRANT CONNECT ON DATABASE eets_blacklist_db TO dbread;
GRANT USAGE ON SCHEMA public TO dbread;
GRANT SELECT ON ALL TABLES IN SCHEMA public TO dbread;

--eets_declaration_db
GRANT CONNECT ON DATABASE eets_declaration_db TO dbread;
GRANT USAGE ON SCHEMA public TO dbread;
GRANT SELECT ON ALL TABLES IN SCHEMA public TO dbread;

--eets_dsrccontract_db
GRANT CONNECT ON DATABASE eets_dsrccontract_db TO dbread;
GRANT USAGE ON SCHEMA public TO dbread;
GRANT SELECT ON ALL TABLES IN SCHEMA public TO dbread;

--eets_errorhandling_db
GRANT CONNECT ON DATABASE eets_errorhandling_db TO dbread;
GRANT USAGE ON SCHEMA public TO dbread;
GRANT SELECT ON ALL TABLES IN SCHEMA public TO dbread;

--eets_journey_db
GRANT CONNECT ON DATABASE eets_journey_db TO dbread;
GRANT USAGE ON SCHEMA public TO dbread;
GRANT SELECT ON ALL TABLES IN SCHEMA public TO dbread;

--eets_manualtask_db
GRANT CONNECT ON DATABASE eets_manualtask_db TO dbread;
GRANT USAGE ON SCHEMA public TO dbread;
GRANT SELECT ON ALL TABLES IN SCHEMA public TO dbread;

--eets_pis_db
GRANT CONNECT ON DATABASE eets_pis_db TO dbread;
GRANT USAGE ON SCHEMA public TO dbread;
GRANT SELECT ON ALL TABLES IN SCHEMA public TO dbread;

--eets_plausibility_db
GRANT CONNECT ON DATABASE eets_plausibility_db TO dbread;
GRANT USAGE ON SCHEMA public TO dbread;
GRANT SELECT ON ALL TABLES IN SCHEMA public TO dbread;

--eets_provider_service_db
GRANT CONNECT ON DATABASE eets_provider_service_db TO dbread;
GRANT USAGE ON SCHEMA public TO dbread;
GRANT SELECT ON ALL TABLES IN SCHEMA public TO dbread;

--eets_riskanalysis_db
GRANT CONNECT ON DATABASE eets_riskanalysis_db TO dbread;
GRANT USAGE ON SCHEMA public TO dbread;
GRANT SELECT ON ALL TABLES IN SCHEMA public TO dbread;

--eets_scheduling_db
GRANT CONNECT ON DATABASE eets_scheduling_db TO dbread;
GRANT USAGE ON SCHEMA public TO dbread;
GRANT SELECT ON ALL TABLES IN SCHEMA public TO dbread;

--nets_pis_db_prod
GRANT CONNECT ON DATABASE nets_pis_db_prod TO dbread;
GRANT USAGE ON SCHEMA public TO dbread;
GRANT SELECT ON ALL TABLES IN SCHEMA public TO dbread;



--revoke and delete user (example)

REVOKE CONNECT ON DATABASE camiuns_errorhandling_db FROM dbread;
REVOKE USAGE ON SCHEMA public FROM dbread;