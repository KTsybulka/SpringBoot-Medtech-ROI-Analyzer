-- Migration V6: Creates and seeds the telemedicine_system_devices table
-- This table stores device information for telemedicine systems, including type, quantities, costs, and benefits.

CREATE TABLE telemedicine_system_devices (
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

-- Insert initial data into the telemedicine_system_devices table
INSERT INTO telemedicine_system_devices
    (id, device_type, default_quantity, initial_cost_per_unit, annual_maintenance_cost_per_unit,
    increased_sales_benefit_per_unit, cost_savings_from_efficiency_per_unit,
    increased_customer_engagement_benefit_per_unit, device_description)
VALUES
    (1, 'High-Quality Webcams', 50, 120, 15, 300, 250, 400, 'For improved video quality during virtual consultations, ensuring clear communication between patients and healthcare providers.'),
    (2, 'Telehealth Platforms', 5, 7000, 1200, 2500, 1800, 1500, 'Software that integrates various devices, allowing for easy management of patient data and communication.'),
    (3, 'Virtual Reality (VR) Tools', 10, 2800, 550, 2000, 1000, 1200, 'For therapy sessions or rehabilitation, enhancing patient engagement during telehealth appointments.'),
    (4, 'Secure Messaging Applications', 100, 45, 8, 250, 200, 350, 'For asynchronous communication between patients and healthcare providers, facilitating ongoing care.'),
    (5, 'Connected Medical Kits', 20, 1800, 280, 1200, 800, 1000, 'Kits that may include various monitoring devices and are used during remote consultations.'),
    (6, 'Chronic Disease Management Platforms', 0, 12000, 2500, 6000, 3500, 2500, 'Integrates multiple monitoring devices to manage specific conditions such as diabetes or hypertension.');