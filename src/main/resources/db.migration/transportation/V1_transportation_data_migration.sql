-- V1_Create_smart_parking_devices_table.sql

CREATE TABLE smart_parking_devices (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    device_type VARCHAR(50),
    default_quantity INT,
    initial_cost_per_unit DECIMAL(10, 2),
    annual_maintenance_cost_per_unit DECIMAL(10, 2),
    increased_sales_benefit_per_unit DECIMAL(10, 2),
    cost_savings_from_efficiency_per_unit DECIMAL(10, 2),
    increased_customer_engagement_benefit_per_unit DECIMAL(10, 2),
    device_description TEXT
);

INSERT INTO smart_parking_devices (device_type, default_quantity, initial_cost_per_unit, annual_maintenance_cost_per_unit, increased_sales_benefit_per_unit, cost_savings_from_efficiency_per_unit, increased_customer_engagement_benefit_per_unit, device_description)
VALUES
('IoT-enabled Parking Sensors', 15, 500.00, 50.00, 1000.00, 600.00, 500.00, 'Detect parking space availability in real-time and send updates to the management system.'),
('Smart Parking Meters', 20, 800.00, 75.00, 1200.00, 800.00, 600.00, 'Enable remote payment via mobile apps and provide real-time pricing based on demand.'),
('AI-powered Parking Management Systems', 10, 5000.00, 600.00, 3000.00, 1500.00, 1000.00, 'Analyze parking patterns to optimize space allocation and reduce congestion.'),
('Vehicle Number Plate Recognition Systems', 8, 2500.00, 300.00, 1500.00, 1200.00, 900.00, 'Automatically identify vehicles entering and exiting parking lots for better management.'),
('Smart Parking App', 0, 1500.00, 200.00, 2500.00, 1000.00, 1200.00, 'Provide real-time information on available parking spaces and allow reservation via mobile app.');
