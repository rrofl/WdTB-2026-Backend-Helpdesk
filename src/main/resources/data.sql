-- Dane startowe aplikacji. Tabele tworzy Hibernate z encji, a ten plik Spring Boot uruchamia zaraz potem.
-- LAB 02: dopiszcie dane do swoich tabel (kolejność: najpierw tabele, na które wskazują klucze obce).
insert into user_account (email, display_name, role, created_at) values
    ('ola@student.merito.pl',   'Ola',   'USER',    current_timestamp),
    ('kuba@student.merito.pl',  'Kuba',  'USER',    current_timestamp),
    ('firma@example.com',       'Firma', 'PARTNER', current_timestamp),
    ('admin@example.com',       'Admin', 'ADMIN',   current_timestamp);

insert into user_account (email, display_name, role, created_at) values
    ('s403807@student.merito.pl', 'Krzysztof', 'USER', current_timestamp);
insert into user_account (email, display_name, role, created_at) values
    ('s697600@student.merito.pl', 'Artur', 'USER', current_timestamp);
insert into user_account (email, display_name, role, created_at) values
    ('s791235@student.merito.pl', 'Karim', 'USER', current_timestamp);

-- ===== LAB 02 · categories =====
insert into categories (name, description, sla_hours, is_active) values
    ('Sprzęt IT i peryferia', 'Awarie stacji roboczych, laptopów, monitorów i drukarek sieciowych', 24, true),
    ('Sieć i VPN', 'Problemy z dostępem do sieci LAN/Wi-Fi oraz konfiguracją tuneli VPN', 8, true),
    ('Uprawnienia i Active Directory', 'Resetowanie haseł, odblokowywanie kont oraz nadawanie dostępów do udziałów', 4, true),
    ('Oprogramowanie biurowe', 'Instalacja i rozwiązywanie problemów z pakietem MS Office oraz pocztą Outlook', 48, true);

-- ===== LAB 02 · tickets (LAB 03: kolumna category_id) =====
insert into tickets (title, description, status, created_at, asset_tag, operating_system, category_id) values
    ('Brak połączenia z VPN po aktualizacji systemu', 'Po wczorajszym restarcie klient VPN wyrzuca błąd autoryzacji certyfikatu podczas próby połączenia z domu.', 'OPEN', '2026-10-20 08:30:00', 'PC-WRO-0142', 'Windows 11 Pro', 2),
    ('Migający ekran w monitorze na drugim stanowisku', 'Monitor Dell wyłącza się na kilka sekund co parę minut. Wymiana kabla DisplayPort nie pomogła.', 'IN_PROGRESS', '2026-10-21 10:15:00', 'NB-WRO-0089', 'Windows 11 Pro', 1),
    ('Prośba o dostęp do folderu sieciowego Działu Kadr', 'Potrzebuję uprawnień do odczytu i zapisu na dysku sieciowym Z: dla nowego pracownika w zespole.', 'RESOLVED', '2026-10-22 14:00:00', 'PC-WRO-0311', 'Windows 10 Enterprise', 3),
    ('Problem z uruchomieniem środowiska Docker na laptopie', 'Demon Dockera nie startuje automatycznie po zalogowaniu, pojawia się błąd uprawnień grupy.', 'CLOSED', '2026-10-19 09:00:00', 'NB-DEV-0012', 'Fedora Linux 41', 4);

-- ===== LAB 03 · technicians (relacja jeden-do-jednego z user_account) =====
insert into technicians (full_name, phone, specialization, hired_on, user_account_id) values
    ('Krzysztof Nowak', '+48 601 100 201', 'Sieci i VPN',                '2023-02-01', 5),
    ('Artur Zieliński',  '+48 601 100 202', 'Sprzęt IT i peryferia',      '2024-06-15', 6),
    ('Karim Hassan',     '+48 601 100 203', 'Active Directory i dostępy', '2025-09-01', 7),
    ('Ola Kowalska',     '+48 601 100 204', 'Oprogramowanie biurowe',     '2022-11-10', 1);

-- ===== LAB 02 · ticket_comments =====
insert into ticket_comments (content, author_name, is_internal, created_at, ticket_id) values
    ('Zweryfikowałem logi na koncentratorze VPN - certyfikat użytkownika wygasł. Generuję nowy klucz.', 'Artur (IT Support)', true, '2026-10-20 09:00:00', 1),
    ('Przesłałem nową paczkę konfiguracyjną na maila. Proszę o sprawdzenie czy połączenie ruszyło.', 'Artur (IT Support)', false, '2026-10-20 09:15:00', 2),
    ('Zamówiłem nową stację dokującą z magazynu do podmiany na jutro rano.', 'Krzysztof (Helpdesk)', true, '2026-10-21 11:30:00', 3),
    ('Uprawnienia w grupie AD zostały nadane. Zmiany zadziałają po ponownym zalogowaniu do stacji.', 'Krzysztof (Admin)', false, '2026-10-22 14:25:00', 4);

-- ===== LAB 03 · device =====
insert into device (serial_number, model, device_type, warranty_until, ticket_id) values
    ('SN-WRO-0142', 'HP EliteDesk 800 G9',     'DESKTOP', '2028-05-15', 1),
    ('SN-WRO-0089', 'Dell Latitude 5540',      'LAPTOP',  '2027-11-30', 2),
    ('SN-WRO-0311', 'Lenovo ThinkCentre M70q', 'DESKTOP', '2027-03-20', 3),
    ('SN-DEV-0012', 'Lenovo ThinkPad T14',     'LAPTOP',  null,         4);

-- ===== LAB 03 · ticket_assignments =====
insert into ticket_assignments (assignment_role, assigned_at, hours_spent, ticket_id, technician_id) values
    ('OWNER',    '2026-10-20 08:45:00', 2.50, 1, 1),
    ('SUPPORT',  '2026-10-20 09:30:00', 0.75, 1, 3),
    ('OWNER',    '2026-10-21 10:40:00', 1.25, 2, 2),
    ('OWNER',    '2026-10-22 14:05:00', 0.50, 3, 3),
    ('REVIEWER', '2026-10-19 09:20:00', 3.00, 4, 4);

