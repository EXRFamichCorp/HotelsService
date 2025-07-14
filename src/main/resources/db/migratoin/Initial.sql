-- информация об отеле
create table if not exists "hotels"(
  id uuid primary key not null,
  
  title varchar not null, --от 3 до 75 символов
  description varchar not null, --до 1500 символов
  is_accept_reservations boolean not null, --принимает ли брони (нужно отключать при внесении каких либо изменений и включать когда изменения вступили в силу)
  stars smallint, --если указано - от 1 до 5
  
  city varchar not null,
  address varchar not null,
  
  latitude decimal(10, 7) not null,
  longitute decimal(10, 7) not null,
  
  phone_number varchar not null,
  email varchar not null,
  
  check_in_time time not null,
  check_out_time time not null
);

-- сервисы которые предоставляет ресторан (трансфер до отеля, завтрак, уборка и тп)
create table if not exists "services"(
  id serial primary key,
  title varchar not null, --от 3 до 75 символов
  description varchar, --до 750 символов
  price decimal(10, 2) not null, --число >= 0
  price_last_edited_at_utc datetime not null --время последнего изменения цены
);


-- Все что связано с удобствами
-- категории удобств
create table if not exists "convenience_categories"(
  id serial primary key,
  title varchar not null, --от 2 до 50 символов
  icon_url varchar not null
);

-- удобства
create table if not exists "conveniences"(
  id serial primary key,
  category_id int references convenience_categories("id"),
  
  title varchar not null
);


-- Все что связано с номерами
-- категории комнат
create table if not exists "room_categories"(
  id serial primary key,
  hotel_id int references hotels("id") not null,

  title varchar not null, --от 3 до 50 символов
  description varchar, --до 500 символов
  
  rooms_count int not null
);

-- удобства которые есть в номерах этой категории
create table if not exists "room_category_conveniences"(
  room_category_id int references room_categories("id") not null,
  convenience_id int references conveniences("id") not null,

  primary key (room_category_id, convenience_id)
);

-- доп. опции для данной категории номера (доп кровать, девчуля в нномер)
create table if not exists "room_category_options"(
  id serial primary key,
  room_category_id int references room_categories("id") not null,
  price decimal(10, 2) not null, --число >= 0
  price_last_edited_at_utc datetime not null --время последнего изменения цены
);

-- Все что связано с тарифами
-- тарифы
create table if not exists "rates"(
  id serial primary key,
  room_category_id int references room_categories("id") not null,
  
  title varchar not null, --от 3 до 50 символов
  description varchar, --до 500 символов

  prepayment_in_percents smallint not null, --предоплата в процентах (от 0 до 100)

  min_nights_count smallint not null,
  max_nights_count smallint not null,
  
  adults_max_number smallint not null, --максимальное количество взрослых в номере
  children_max_number smallint  not null, --максимальное количество детей в номере
  pets_max_number smallint not null --максимальное количество питомцев в номере
);

-- включенные сервисы в тариф с указанной скидкой на стоимость сервиса (если платный сервис)
create table if not exists "rate_included_services"(
  rate_id int references rates("id") not null,
  service_id int references services("id") not null,
  discount smallint not null, --скидка (от 0 до 100)
  
  primary key (rate_id, service_id)
);

