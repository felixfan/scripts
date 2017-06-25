sqlite3 geneticTestingDB.db

CREATE TABLE cancer_table(
    ID INT  PRIMARY KEY NOT NULL,
    Cancer TEXT NOT NULL,
    Gene TEXT,
    Variant TEXT NOT NULL,
    RiskAllele TEXT NOT NULL,
    OtherAllele TEXT NOT NULL,
    DesRR TEXT,
    DesRO TEXT,
    DesOO TEXT
 );

INSERT INTO cancer_table (ID, Cancer, Gene, Variant, RiskAllele, OtherAllele)
VALUES (1, 'NSCLC', 'EGFR', 'rs12345', 'G', 'T');

.header on
.mode column
SELECT * FROM cancer_table;

