create table transaction (
    id          int4 generated by default as identity,
    account_id  int4,
    value       int8,
    primary key (id)
)