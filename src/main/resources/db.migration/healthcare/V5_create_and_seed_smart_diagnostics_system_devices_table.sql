-- Migration V5: Creates and seeds the smart_diagnostics_system_devices table
-- This table stores device information for smart diagnostics systems, including type, quantities, costs, and benefits.

CREATE TABLE smart_diagnostics_system_devices (
    id SERIAL PRIMARY KEY,
    device_type VARCHAR(50),
    default_quantity INT,
    initial_cost_per_unit DECIMAL(10, 2),
    annual_maintenance_cost_per_unit DECIMAL(10, 2),
    increased_sales_benefit_per_unit DECIMAL(10, 2),
    cost_savings_from_efficiency_per_unit DECIMAL(10, 2),
    increased_customer_engagement_benefit_per_unit DECIMAL(10, 2),
    device_description TEXT
);

-- Insert initial data into the smart_diagnostics_system_devices table
INSERT INTO smart_diagnostics_system_devices
    (id, device_type, default_quantity, initial_cost_per_unit, annual_maintenance_cost_per_unit,
    increased_sales_benefit_per_unit, cost_savings_from_efficiency_per_unit,
    increased_customer_engagement_benefit_per_unit, device_description)
VALUES
    (1, 'Patient Monitoring Systems', 5, 3500, 500, 2000, 1200, 800, 'Collects and analyzes patient health data to assist in diagnostic processes.'),
    (2, 'Wearable ECG Monitors', 3, 1500, 200, 1200, 700, 500, 'Provides continuous ECG data critical for diagnosing heart-related issues.'),
    (3, 'Smart Stethoscopes', 4, 1200, 150, 900, 600, 400, 'Enhances diagnostic capabilities by allowing remote analysis of heart and lung sounds.'),
    (4, 'Smart Blood Pressure Monitors', 6, 250, 50, 400, 300, 250, 'Essential for diagnosing hypertension and monitoring cardiovascular health.'),
    (5, 'Smart Glucose Monitors', 5, 800, 100, 700, 500, 400, 'Provides continuous glucose monitoring data, crucial for managing diabetes.'),
    (6, 'Connected Inhalers', 3, 1000, 150, 600, 400, 350, 'Ensures asthma patients adhere to medication regimens, aiding in respiratory diagnostics.'),
    (7, 'Voice-Activated Assistants', 0, 600, 80, 300, 200, 150, 'Assists in gathering patient history and symptoms via voice commands, streamlining diagnostic processes.'),
    (8, 'Telemedicine Consultation Units', 0, 5000, 750, 3000, 1500, 1000, 'Enables remote consultations with healthcare providers for advanced diagnostic support and patient monitoring.');