# jdbcToJpa
jpa pracice

enable to h2 console --spring.h2.console.enabled=true
console url - http://localhost:2222/h2-console
modify jdbc url to jdbc:h2:mem:testdb

JdbcTemplate is auto configured. 
see the autoconfiguration report - logging.level.root=debug

if column names are not matching with entity columns , we need to go for customRow mapper

# EntityMangaer

the entity manager manages the entities all the operations that you are performing in a specific session.
all operations are stored in persistence context.
entity manager is the interface to the persistence context

when you're connecting to embedded database schema gets automatically created , we will get error-- Table "PERSON" already exists; SQL statement
so comment create statement in sql.

if you want to update or insert you need to call the merge method.if id is present  it will update else it will create
