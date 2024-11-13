-- Migration V1: Creates and seeds the smart_hospital_devices table
-- This table stores device information for smart hospital systems, including device types, quantities, costs, and benefits.

CREATE TABLE smart_hospital_devices (
    id INT PRIMARY KEY AUTO_INCREMENT,
    device_type VARCHAR(255) NOT NULL,
    default_quantity INT NOT NULL,
    initial_cost_per_unit DECIMAL(10, 2) NOT NULL,
    annual_maintenance_cost_per_unit DECIMAL(10, 2) NOT NULL,
    increased_sales_benefit_per_unit DECIMAL(10, 2) NOT NULL,
    cost_savings_from_efficiency_per_unit DECIMAL(10, 2) NOT NULL,
    increased_customer_engagement_benefit_per_unit DECIMAL(10, 2) NOT NULL,
    device_description TEXT NOT NULL
);

-- Insert initial data into the smart_hospital_devices table
INSERT INTO smart_hospital_devices
    (device_type, default_quantity, initial_cost_per_unit, annual_maintenance_cost_per_unit,
     increased_sales_benefit_per_unit, cost_savings_from_efficiency_per_unit,
     increased_customer_engagement_benefit_per_unit, device_description)
VALUES
    ('Electronic Health Records (EHR)', 10, 25000.00, 2500.00, 15000.00, 5000.00, 3000.00,
     'Digital systems for managing patient records, improving accessibility and collaboration among providers.'),
    ('Smart Bed Systems', 5, 8000.00, 800.00, 3000.00, 2500.00, 1500.00,
     'Beds equipped with sensors to monitor patient vitals and adjust settings based on needs.'),
    ('Wearable Health Monitors', 20, 300.00, 50.00, 200.00, 100.00, 75.00,
     'Devices that continuously track metrics (e.g., heart rate, blood pressure) and transmit data to providers.'),
    ('Telehealth Platforms', 1, 10000.00, 1200.00, 20000.00, 10000.00, 5000.00,
     'Facilitates remote consultations between patients and providers, improving access to care.'),
    ('Smart Infusion Pumps', 6, 5000.00, 500.00, 2000.00, 1000.00, 800.00,
     'Automatically deliver medication with precise dosing, reducing the risk of errors.'),
    ('Patient Tracking Systems', 0, 2000.00, 300.00, 1500.00, 500.00, 400.00,
     'Use RFID or GPS technology to monitor the location of patients within the hospital, improving safety.'),
    ('Robotic Surgery Systems', 0, 1000000.00, 100000.00, 200000.00, 50000.00, 30000.00,
     'Enhance surgical precision and reduce recovery times through minimally invasive procedures.');