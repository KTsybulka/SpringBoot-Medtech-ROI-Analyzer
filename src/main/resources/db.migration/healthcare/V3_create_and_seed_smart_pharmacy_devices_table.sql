-- Migration V3: Creates and seeds the smart_pharmacy_devices table
-- This table stores device information for smart pharmacy systems, including type, quantities, costs, and benefits.

CREATE TABLE smart_pharmacy_devices (
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

-- Insert initial data into the smart_pharmacy_devices table
INSERT INTO smart_pharmacy_devices
    (device_type, default_quantity, initial_cost_per_unit, annual_maintenance_cost_per_unit,
    increased_sales_benefit_per_unit, cost_savings_from_efficiency_per_unit,
    increased_customer_engagement_benefit_per_unit, device_description)
VALUES
    ('Smart Pill Dispensers', 5, 1500.00, 200.00, 800.00, 500.00, 300.00,
     'Automate the dispensing of medications, ensuring patients receive the correct dosage at the right time.'),
    ('Medication Management Software', 3, 1200.00, 250.00, 600.00, 400.00, 250.00,
     'Helps pharmacists manage inventory, track prescriptions, and monitor patient adherence to medication regimens.'),
    ('Barcode Scanners', 10, 300.00, 50.00, 150.00, 100.00, 80.00,
     'Used for scanning medications to verify prescriptions and ensure accuracy in dispensing.'),
    ('Voice-Activated Assistants', 2, 400.00, 60.00, 200.00, 120.00, 100.00,
     'Assist patients with reminders about medication schedules or pharmacy services.'),
    ('Automated Prescription Refill Systems', 1, 1000.00, 150.00, 500.00, 300.00, 200.00,
     'Allow patients to request refills easily through an app or online platform.'),
    ('Telepharmacy Solutions', 0, 2000.00, 300.00, 1000.00, 500.00, 400.00,
     'Enable remote consultations and medication delivery services for patients in underserved areas.');