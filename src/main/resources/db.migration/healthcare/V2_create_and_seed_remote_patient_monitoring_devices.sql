-- Migration V2: Creates and seeds the remote_patient_monitoring_devices table
-- This table stores device information for remote patient monitoring systems, including type, quantities, costs, and benefits.

CREATE TABLE remote_patient_monitoring_devices (
    id SERIAL PRIMARY KEY,
    device_type VARCHAR(100),
    default_quantity INT,
    initial_cost_per_unit DECIMAL(10, 2),
    annual_maintenance_cost_per_unit DECIMAL(10, 2),
    increased_sales_benefit_per_unit DECIMAL(10, 2),
    cost_savings_from_efficiency_per_unit DECIMAL(10, 2),
    increased_customer_engagement_benefit_per_unit DECIMAL(10, 2),
    device_description TEXT
);

-- Insert initial data into the remote_patient_monitoring_devices table
INSERT INTO remote_patient_monitoring_devices
    (device_type, default_quantity, initial_cost_per_unit, annual_maintenance_cost_per_unit,
     increased_sales_benefit_per_unit, cost_savings_from_efficiency_per_unit,
     increased_customer_engagement_benefit_per_unit, device_description)
VALUES
    ('Patient Monitoring Systems', 4, 1500.00, 200.00, 500.00, 300.00, 200.00,
     'Essential for tracking patients'' vital signs and other health metrics remotely.'),
    ('Wearable ECG Monitors', 3, 1200.00, 250.00, 600.00, 400.00, 250.00,
     'Used for continuous monitoring of heart health, allowing proactive management of cardiovascular issues.'),
    ('Smart Blood Pressure Monitors', 3, 350.00, 50.00, 150.00, 100.00, 80.00,
     'Enables frequent blood pressure monitoring, providing insights for hypertension management.'),
    ('Smart Stethoscopes', 5, 800.00, 100.00, 300.00, 200.00, 150.00,
     'Allows remote listening to heart and lung sounds, aiding in telemedicine diagnosis.'),
    ('Smart Pillows', 2, 250.00, 30.00, 100.00, 70.00, 60.00,
     'Monitors sleep quality and provides insights into sleep patterns, beneficial for patient recovery.'),
    ('Smart Beds', 2, 3000.00, 500.00, 900.00, 600.00, 450.00,
     'Tracks movement and vital signs, improving patient comfort and providing valuable health data.'),
    ('Smart Glucose Monitors', 0, 200.00, 25.00, 120.00, 100.00, 90.00,
     'Enables continuous blood sugar monitoring, essential for diabetic patient care.'),
    ('Wearable Fitness Trackers', 0, 150.00, 20.00, 80.00, 50.00, 40.00,
     'Tracks physical activity, heart rate, and sleep patterns, encouraging a healthy lifestyle.');