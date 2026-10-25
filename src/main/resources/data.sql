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
    ('john@student.merito.pl', 'John', 'USER', current_timestamp);

-- ===== LAB 02 · categories =====
insert into categories (name, description, sla_hours, is_active) values
    ('Sprzęt IT i peryferia', 'Awarie stacji roboczych, laptopów, monitorów i drukarek sieciowych', 24, true),
    ('Sieć i VPN', 'Problemy z dostępem do sieci LAN/Wi-Fi oraz konfiguracją tuneli VPN', 8, true),
    ('Uprawnienia i Active Directory', 'Resetowanie haseł, odblokowywanie kont oraz nadawanie dostępów do udziałów', 4, true),
    ('Oprogramowanie biurowe', 'Instalacja i rozwiązywanie problemów z pakietem MS Office oraz pocztą Outlook', 48, true);

-- ===== LAB 02 · tickets =====
insert into tickets (title, description, status, created_at, asset_tag, operating_system) values
    ('Brak połączenia z VPN po aktualizacji systemu', 'Po wczorajszym restarcie klient VPN wyrzuca błąd autoryzacji certyfikatu podczas próby połączenia z domu.', 'OPEN', '2026-10-20 08:30:00', 'PC-WRO-0142', 'Windows 11 Pro'),
    ('Migający ekran w monitorze na drugim stanowisku', 'Monitor Dell wyłącza się na kilka sekund co parę minut. Wymiana kabla DisplayPort nie pomogła.', 'IN_PROGRESS', '2026-10-21 10:15:00', 'NB-WRO-0089', 'Windows 11 Pro'),
    ('Prośba o dostęp do folderu sieciowego Działu Kadr', 'Potrzebuję uprawnień do odczytu i zapisu na dysku sieciowym Z: dla nowego pracownika w zespole.', 'RESOLVED', '2026-10-22 14:00:00', 'PC-WRO-0311', 'Windows 10 Enterprise'),
    ('Problem z uruchomieniem środowiska Docker na laptopie', 'Demon Dockera nie startuje automatycznie po zalogowaniu, pojawia się błąd uprawnień grupy.', 'CLOSED', '2026-10-19 09:00:00', 'NB-DEV-0012', 'Fedora Linux 41');

-- ===== LAB 02 · ticket_comments =====
insert into ticket_comments (content, author_name, is_internal, created_at) values
    ('Zweryfikowałem logi na koncentratorze VPN - certyfikat użytkownika wygasł. Generuję nowy klucz.', 'Artur (IT Support)', true, '2026-10-20 09:00:00'),
    ('Przesłałem nową paczkę konfiguracyjną na maila. Proszę o sprawdzenie czy połączenie ruszyło.', 'Artur (IT Support)', false, '2026-10-20 09:15:00'),
    ('Zamówiłem nową stację dokującą z magazynu do podmiany na jutro rano.', 'Krzysztof (Helpdesk)', true, '2026-10-21 11:30:00'),
    ('Uprawnienia w grupie AD zostały nadane. Zmiany zadziałają po ponownym zalogowaniu do stacji.', 'Krzysztof (Admin)', false, '2026-10-22 14:25:00');