package models
// AUTO-GENERATED Slick data model
/** Stand-alone Slick data model for immediate use */
object Tables extends {
  val profile = slick.jdbc.MySQLProfile
} with Tables

/** Slick data model trait for extension, choice of backend or usage in the cake pattern. (Make sure to initialize this late.) */
trait Tables {
  val profile: slick.jdbc.JdbcProfile
  import profile.api._
  import slick.model.ForeignKeyAction
  // NOTE: GetResult mappers for plain SQL are only generated for tables where Slick knows how to map the types of all columns.
  import slick.jdbc.{GetResult => GR}

  /** DDL for all tables. Call .create to execute. */
  lazy val schema: profile.SchemaDescription = Array(Actor.schema, ActorInfo.schema, Address.schema, Category.schema, City.schema, Country.schema, Customer.schema, CustomerList.schema, Film.schema, FilmActor.schema, FilmCategory.schema, FilmList.schema, FilmText.schema, Inventory.schema, Language.schema, NicerButSlowerFilmList.schema, Payment.schema, Rental.schema, SalesByFilmCategory.schema, SalesByStore.schema, Staff.schema, StaffList.schema, Store.schema).reduceLeft(_ ++ _)
  @deprecated("Use .schema instead of .ddl", "3.0")
  def ddl = schema

  /** Entity class storing rows of table Actor
   *  @param actorId Database column actor_id SqlType(SMALLINT UNSIGNED), AutoInc, PrimaryKey
   *  @param firstName Database column first_name SqlType(VARCHAR), Length(45,true)
   *  @param lastName Database column last_name SqlType(VARCHAR), Length(45,true)
   *  @param lastUpdate Database column last_update SqlType(TIMESTAMP) */
  final case class ActorRow(actorId: Short, firstName: String, lastName: String, lastUpdate: java.sql.Timestamp)
  /** GetResult implicit for fetching ActorRow objects using plain SQL queries */
  implicit def GetResultActorRow(implicit e0: GR[Short], e1: GR[String], e2: GR[java.sql.Timestamp]): GR[ActorRow] = GR{
    prs => import prs._
    ActorRow.tupled((<<[Short], <<[String], <<[String], <<[java.sql.Timestamp]))
  }
  /** Table description of table actor. Objects of this class serve as prototypes for rows in queries. */
  class Actor(_tableTag: Tag) extends profile.api.Table[ActorRow](_tableTag, Some("sakila"), "actor") {
    def * = (actorId, firstName, lastName, lastUpdate) <> (ActorRow.tupled, ActorRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(actorId), Rep.Some(firstName), Rep.Some(lastName), Rep.Some(lastUpdate)).shaped.<>({r=>import r._; _1.map(_=> ActorRow.tupled((_1.get, _2.get, _3.get, _4.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column actor_id SqlType(SMALLINT UNSIGNED), AutoInc, PrimaryKey */
    val actorId: Rep[Short] = column[Short]("actor_id", O.AutoInc, O.PrimaryKey)
    /** Database column first_name SqlType(VARCHAR), Length(45,true) */
    val firstName: Rep[String] = column[String]("first_name", O.Length(45,varying=true))
    /** Database column last_name SqlType(VARCHAR), Length(45,true) */
    val lastName: Rep[String] = column[String]("last_name", O.Length(45,varying=true))
    /** Database column last_update SqlType(TIMESTAMP) */
    val lastUpdate: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("last_update")

    /** Index over (lastName) (database name idx_actor_last_name) */
    val index1 = index("idx_actor_last_name", lastName)
  }
  /** Collection-like TableQuery object for table Actor */
  lazy val Actor = new TableQuery(tag => new Actor(tag))

  /** Entity class storing rows of table ActorInfo
   *  @param actorId Database column actor_id SqlType(SMALLINT UNSIGNED), Default(0)
   *  @param firstName Database column first_name SqlType(VARCHAR), Length(45,true)
   *  @param lastName Database column last_name SqlType(VARCHAR), Length(45,true)
   *  @param filmInfo Database column film_info SqlType(TEXT), Default(None) */
  final case class ActorInfoRow(actorId: Short = 0, firstName: String, lastName: String, filmInfo: Option[String] = None)
  /** GetResult implicit for fetching ActorInfoRow objects using plain SQL queries */
  implicit def GetResultActorInfoRow(implicit e0: GR[Short], e1: GR[String], e2: GR[Option[String]]): GR[ActorInfoRow] = GR{
    prs => import prs._
    ActorInfoRow.tupled((<<[Short], <<[String], <<[String], <<?[String]))
  }
  /** Table description of table actor_info. Objects of this class serve as prototypes for rows in queries. */
  class ActorInfo(_tableTag: Tag) extends profile.api.Table[ActorInfoRow](_tableTag, Some("sakila"), "actor_info") {
    def * = (actorId, firstName, lastName, filmInfo) <> (ActorInfoRow.tupled, ActorInfoRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(actorId), Rep.Some(firstName), Rep.Some(lastName), filmInfo).shaped.<>({r=>import r._; _1.map(_=> ActorInfoRow.tupled((_1.get, _2.get, _3.get, _4)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column actor_id SqlType(SMALLINT UNSIGNED), Default(0) */
    val actorId: Rep[Short] = column[Short]("actor_id", O.Default(0))
    /** Database column first_name SqlType(VARCHAR), Length(45,true) */
    val firstName: Rep[String] = column[String]("first_name", O.Length(45,varying=true))
    /** Database column last_name SqlType(VARCHAR), Length(45,true) */
    val lastName: Rep[String] = column[String]("last_name", O.Length(45,varying=true))
    /** Database column film_info SqlType(TEXT), Default(None) */
    val filmInfo: Rep[Option[String]] = column[Option[String]]("film_info", O.Default(None))
  }
  /** Collection-like TableQuery object for table ActorInfo */
  lazy val ActorInfo = new TableQuery(tag => new ActorInfo(tag))

  /** Entity class storing rows of table Address
   *  @param addressId Database column address_id SqlType(SMALLINT UNSIGNED), AutoInc, PrimaryKey
   *  @param address Database column address SqlType(VARCHAR), Length(50,true)
   *  @param address2 Database column address2 SqlType(VARCHAR), Length(50,true), Default(None)
   *  @param district Database column district SqlType(VARCHAR), Length(20,true)
   *  @param cityId Database column city_id SqlType(SMALLINT UNSIGNED)
   *  @param postalCode Database column postal_code SqlType(VARCHAR), Length(10,true), Default(None)
   *  @param phone Database column phone SqlType(VARCHAR), Length(20,true)
   *  @param lastUpdate Database column last_update SqlType(TIMESTAMP) */
  final case class AddressRow(addressId: Short, address: String, address2: Option[String] = None, district: String, cityId: Short, postalCode: Option[String] = None, phone: String, lastUpdate: java.sql.Timestamp)
  /** GetResult implicit for fetching AddressRow objects using plain SQL queries */
  implicit def GetResultAddressRow(implicit e0: GR[Short], e1: GR[String], e2: GR[Option[String]], e3: GR[java.sql.Timestamp]): GR[AddressRow] = GR{
    prs => import prs._
    AddressRow.tupled((<<[Short], <<[String], <<?[String], <<[String], <<[Short], <<?[String], <<[String], <<[java.sql.Timestamp]))
  }
  /** Table description of table address. Objects of this class serve as prototypes for rows in queries. */
  class Address(_tableTag: Tag) extends profile.api.Table[AddressRow](_tableTag, Some("sakila"), "address") {
    def * = (addressId, address, address2, district, cityId, postalCode, phone, lastUpdate) <> (AddressRow.tupled, AddressRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(addressId), Rep.Some(address), address2, Rep.Some(district), Rep.Some(cityId), postalCode, Rep.Some(phone), Rep.Some(lastUpdate)).shaped.<>({r=>import r._; _1.map(_=> AddressRow.tupled((_1.get, _2.get, _3, _4.get, _5.get, _6, _7.get, _8.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column address_id SqlType(SMALLINT UNSIGNED), AutoInc, PrimaryKey */
    val addressId: Rep[Short] = column[Short]("address_id", O.AutoInc, O.PrimaryKey)
    /** Database column address SqlType(VARCHAR), Length(50,true) */
    val address: Rep[String] = column[String]("address", O.Length(50,varying=true))
    /** Database column address2 SqlType(VARCHAR), Length(50,true), Default(None) */
    val address2: Rep[Option[String]] = column[Option[String]]("address2", O.Length(50,varying=true), O.Default(None))
    /** Database column district SqlType(VARCHAR), Length(20,true) */
    val district: Rep[String] = column[String]("district", O.Length(20,varying=true))
    /** Database column city_id SqlType(SMALLINT UNSIGNED) */
    val cityId: Rep[Short] = column[Short]("city_id")
    /** Database column postal_code SqlType(VARCHAR), Length(10,true), Default(None) */
    val postalCode: Rep[Option[String]] = column[Option[String]]("postal_code", O.Length(10,varying=true), O.Default(None))
    /** Database column phone SqlType(VARCHAR), Length(20,true) */
    val phone: Rep[String] = column[String]("phone", O.Length(20,varying=true))
    /** Database column last_update SqlType(TIMESTAMP) */
    val lastUpdate: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("last_update")

    /** Foreign key referencing City (database name fk_address_city) */
    lazy val cityFk = foreignKey("fk_address_city", cityId, City)(r => r.cityId, onUpdate=ForeignKeyAction.Cascade, onDelete=ForeignKeyAction.NoAction)
  }
  /** Collection-like TableQuery object for table Address */
  lazy val Address = new TableQuery(tag => new Address(tag))

  /** Entity class storing rows of table Category
   *  @param categoryId Database column category_id SqlType(TINYINT UNSIGNED), AutoInc, PrimaryKey
   *  @param name Database column name SqlType(VARCHAR), Length(25,true)
   *  @param lastUpdate Database column last_update SqlType(TIMESTAMP) */
  final case class CategoryRow(categoryId: Byte, name: String, lastUpdate: java.sql.Timestamp)
  /** GetResult implicit for fetching CategoryRow objects using plain SQL queries */
  implicit def GetResultCategoryRow(implicit e0: GR[Byte], e1: GR[String], e2: GR[java.sql.Timestamp]): GR[CategoryRow] = GR{
    prs => import prs._
    CategoryRow.tupled((<<[Byte], <<[String], <<[java.sql.Timestamp]))
  }
  /** Table description of table category. Objects of this class serve as prototypes for rows in queries. */
  class Category(_tableTag: Tag) extends profile.api.Table[CategoryRow](_tableTag, Some("sakila"), "category") {
    def * = (categoryId, name, lastUpdate) <> (CategoryRow.tupled, CategoryRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(categoryId), Rep.Some(name), Rep.Some(lastUpdate)).shaped.<>({r=>import r._; _1.map(_=> CategoryRow.tupled((_1.get, _2.get, _3.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column category_id SqlType(TINYINT UNSIGNED), AutoInc, PrimaryKey */
    val categoryId: Rep[Byte] = column[Byte]("category_id", O.AutoInc, O.PrimaryKey)
    /** Database column name SqlType(VARCHAR), Length(25,true) */
    val name: Rep[String] = column[String]("name", O.Length(25,varying=true))
    /** Database column last_update SqlType(TIMESTAMP) */
    val lastUpdate: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("last_update")
  }
  /** Collection-like TableQuery object for table Category */
  lazy val Category = new TableQuery(tag => new Category(tag))

  /** Entity class storing rows of table City
   *  @param cityId Database column city_id SqlType(SMALLINT UNSIGNED), AutoInc, PrimaryKey
   *  @param city Database column city SqlType(VARCHAR), Length(50,true)
   *  @param countryId Database column country_id SqlType(SMALLINT UNSIGNED)
   *  @param lastUpdate Database column last_update SqlType(TIMESTAMP) */
  final case class CityRow(cityId: Short, city: String, countryId: Short, lastUpdate: java.sql.Timestamp)
  /** GetResult implicit for fetching CityRow objects using plain SQL queries */
  implicit def GetResultCityRow(implicit e0: GR[Short], e1: GR[String], e2: GR[java.sql.Timestamp]): GR[CityRow] = GR{
    prs => import prs._
    CityRow.tupled((<<[Short], <<[String], <<[Short], <<[java.sql.Timestamp]))
  }
  /** Table description of table city. Objects of this class serve as prototypes for rows in queries. */
  class City(_tableTag: Tag) extends profile.api.Table[CityRow](_tableTag, Some("sakila"), "city") {
    def * = (cityId, city, countryId, lastUpdate) <> (CityRow.tupled, CityRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(cityId), Rep.Some(city), Rep.Some(countryId), Rep.Some(lastUpdate)).shaped.<>({r=>import r._; _1.map(_=> CityRow.tupled((_1.get, _2.get, _3.get, _4.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column city_id SqlType(SMALLINT UNSIGNED), AutoInc, PrimaryKey */
    val cityId: Rep[Short] = column[Short]("city_id", O.AutoInc, O.PrimaryKey)
    /** Database column city SqlType(VARCHAR), Length(50,true) */
    val city: Rep[String] = column[String]("city", O.Length(50,varying=true))
    /** Database column country_id SqlType(SMALLINT UNSIGNED) */
    val countryId: Rep[Short] = column[Short]("country_id")
    /** Database column last_update SqlType(TIMESTAMP) */
    val lastUpdate: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("last_update")

    /** Foreign key referencing Country (database name fk_city_country) */
    lazy val countryFk = foreignKey("fk_city_country", countryId, Country)(r => r.countryId, onUpdate=ForeignKeyAction.Cascade, onDelete=ForeignKeyAction.NoAction)
  }
  /** Collection-like TableQuery object for table City */
  lazy val City = new TableQuery(tag => new City(tag))

  /** Entity class storing rows of table Country
   *  @param countryId Database column country_id SqlType(SMALLINT UNSIGNED), AutoInc, PrimaryKey
   *  @param country Database column country SqlType(VARCHAR), Length(50,true)
   *  @param lastUpdate Database column last_update SqlType(TIMESTAMP) */
  final case class CountryRow(countryId: Short, country: String, lastUpdate: java.sql.Timestamp)
  /** GetResult implicit for fetching CountryRow objects using plain SQL queries */
  implicit def GetResultCountryRow(implicit e0: GR[Short], e1: GR[String], e2: GR[java.sql.Timestamp]): GR[CountryRow] = GR{
    prs => import prs._
    CountryRow.tupled((<<[Short], <<[String], <<[java.sql.Timestamp]))
  }
  /** Table description of table country. Objects of this class serve as prototypes for rows in queries. */
  class Country(_tableTag: Tag) extends profile.api.Table[CountryRow](_tableTag, Some("sakila"), "country") {
    def * = (countryId, country, lastUpdate) <> (CountryRow.tupled, CountryRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(countryId), Rep.Some(country), Rep.Some(lastUpdate)).shaped.<>({r=>import r._; _1.map(_=> CountryRow.tupled((_1.get, _2.get, _3.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column country_id SqlType(SMALLINT UNSIGNED), AutoInc, PrimaryKey */
    val countryId: Rep[Short] = column[Short]("country_id", O.AutoInc, O.PrimaryKey)
    /** Database column country SqlType(VARCHAR), Length(50,true) */
    val country: Rep[String] = column[String]("country", O.Length(50,varying=true))
    /** Database column last_update SqlType(TIMESTAMP) */
    val lastUpdate: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("last_update")
  }
  /** Collection-like TableQuery object for table Country */
  lazy val Country = new TableQuery(tag => new Country(tag))

  /** Entity class storing rows of table Customer
   *  @param customerId Database column customer_id SqlType(SMALLINT UNSIGNED), AutoInc, PrimaryKey
   *  @param storeId Database column store_id SqlType(TINYINT UNSIGNED)
   *  @param firstName Database column first_name SqlType(VARCHAR), Length(45,true)
   *  @param lastName Database column last_name SqlType(VARCHAR), Length(45,true)
   *  @param email Database column email SqlType(VARCHAR), Length(50,true), Default(None)
   *  @param addressId Database column address_id SqlType(SMALLINT UNSIGNED)
   *  @param active Database column active SqlType(BIT), Default(true)
   *  @param createDate Database column create_date SqlType(DATETIME)
   *  @param lastUpdate Database column last_update SqlType(TIMESTAMP) */
  final case class CustomerRow(customerId: Short, storeId: Byte, firstName: String, lastName: String, email: Option[String] = None, addressId: Short, active: Boolean = true, createDate: java.sql.Timestamp, lastUpdate: java.sql.Timestamp)
  /** GetResult implicit for fetching CustomerRow objects using plain SQL queries */
  implicit def GetResultCustomerRow(implicit e0: GR[Short], e1: GR[Byte], e2: GR[String], e3: GR[Option[String]], e4: GR[Boolean], e5: GR[java.sql.Timestamp]): GR[CustomerRow] = GR{
    prs => import prs._
    CustomerRow.tupled((<<[Short], <<[Byte], <<[String], <<[String], <<?[String], <<[Short], <<[Boolean], <<[java.sql.Timestamp], <<[java.sql.Timestamp]))
  }
  /** Table description of table customer. Objects of this class serve as prototypes for rows in queries. */
  class Customer(_tableTag: Tag) extends profile.api.Table[CustomerRow](_tableTag, Some("sakila"), "customer") {
    def * = (customerId, storeId, firstName, lastName, email, addressId, active, createDate, lastUpdate) <> (CustomerRow.tupled, CustomerRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(customerId), Rep.Some(storeId), Rep.Some(firstName), Rep.Some(lastName), email, Rep.Some(addressId), Rep.Some(active), Rep.Some(createDate), Rep.Some(lastUpdate)).shaped.<>({r=>import r._; _1.map(_=> CustomerRow.tupled((_1.get, _2.get, _3.get, _4.get, _5, _6.get, _7.get, _8.get, _9.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column customer_id SqlType(SMALLINT UNSIGNED), AutoInc, PrimaryKey */
    val customerId: Rep[Short] = column[Short]("customer_id", O.AutoInc, O.PrimaryKey)
    /** Database column store_id SqlType(TINYINT UNSIGNED) */
    val storeId: Rep[Byte] = column[Byte]("store_id")
    /** Database column first_name SqlType(VARCHAR), Length(45,true) */
    val firstName: Rep[String] = column[String]("first_name", O.Length(45,varying=true))
    /** Database column last_name SqlType(VARCHAR), Length(45,true) */
    val lastName: Rep[String] = column[String]("last_name", O.Length(45,varying=true))
    /** Database column email SqlType(VARCHAR), Length(50,true), Default(None) */
    val email: Rep[Option[String]] = column[Option[String]]("email", O.Length(50,varying=true), O.Default(None))
    /** Database column address_id SqlType(SMALLINT UNSIGNED) */
    val addressId: Rep[Short] = column[Short]("address_id")
    /** Database column active SqlType(BIT), Default(true) */
    val active: Rep[Boolean] = column[Boolean]("active", O.Default(true))
    /** Database column create_date SqlType(DATETIME) */
    val createDate: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("create_date")
    /** Database column last_update SqlType(TIMESTAMP) */
    val lastUpdate: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("last_update")

    /** Foreign key referencing Address (database name fk_customer_address) */
    lazy val addressFk = foreignKey("fk_customer_address", addressId, Address)(r => r.addressId, onUpdate=ForeignKeyAction.Cascade, onDelete=ForeignKeyAction.NoAction)
    /** Foreign key referencing Store (database name fk_customer_store) */
    lazy val storeFk = foreignKey("fk_customer_store", storeId, Store)(r => r.storeId, onUpdate=ForeignKeyAction.Cascade, onDelete=ForeignKeyAction.NoAction)

    /** Index over (lastName) (database name idx_last_name) */
    val index1 = index("idx_last_name", lastName)
  }
  /** Collection-like TableQuery object for table Customer */
  lazy val Customer = new TableQuery(tag => new Customer(tag))

  /** Entity class storing rows of table CustomerList
   *  @param id Database column ID SqlType(SMALLINT UNSIGNED), Default(0)
   *  @param name Database column name SqlType(VARCHAR), Length(91,true), Default(None)
   *  @param address Database column address SqlType(VARCHAR), Length(50,true)
   *  @param `zip code` Database column zip code SqlType(VARCHAR), Length(10,true), Default(None)
   *  @param phone Database column phone SqlType(VARCHAR), Length(20,true)
   *  @param city Database column city SqlType(VARCHAR), Length(50,true)
   *  @param country Database column country SqlType(VARCHAR), Length(50,true)
   *  @param notes Database column notes SqlType(VARCHAR), Length(6,true), Default()
   *  @param sid Database column SID SqlType(TINYINT UNSIGNED) */
  final case class CustomerListRow(id: Short = 0, name: Option[String] = None, address: String, `zip code`: Option[String] = None, phone: String, city: String, country: String, notes: String = "", sid: Byte)
  /** GetResult implicit for fetching CustomerListRow objects using plain SQL queries */
  implicit def GetResultCustomerListRow(implicit e0: GR[Short], e1: GR[Option[String]], e2: GR[String], e3: GR[Byte]): GR[CustomerListRow] = GR{
    prs => import prs._
    CustomerListRow.tupled((<<[Short], <<?[String], <<[String], <<?[String], <<[String], <<[String], <<[String], <<[String], <<[Byte]))
  }
  /** Table description of table customer_list. Objects of this class serve as prototypes for rows in queries. */
  class CustomerList(_tableTag: Tag) extends profile.api.Table[CustomerListRow](_tableTag, Some("sakila"), "customer_list") {
    def * = (id, name, address, `zip code`, phone, city, country, notes, sid) <> (CustomerListRow.tupled, CustomerListRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), name, Rep.Some(address), `zip code`, Rep.Some(phone), Rep.Some(city), Rep.Some(country), Rep.Some(notes), Rep.Some(sid)).shaped.<>({r=>import r._; _1.map(_=> CustomerListRow.tupled((_1.get, _2, _3.get, _4, _5.get, _6.get, _7.get, _8.get, _9.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column ID SqlType(SMALLINT UNSIGNED), Default(0) */
    val id: Rep[Short] = column[Short]("ID", O.Default(0))
    /** Database column name SqlType(VARCHAR), Length(91,true), Default(None) */
    val name: Rep[Option[String]] = column[Option[String]]("name", O.Length(91,varying=true), O.Default(None))
    /** Database column address SqlType(VARCHAR), Length(50,true) */
    val address: Rep[String] = column[String]("address", O.Length(50,varying=true))
    /** Database column zip code SqlType(VARCHAR), Length(10,true), Default(None) */
    val `zip code`: Rep[Option[String]] = column[Option[String]]("zip code", O.Length(10,varying=true), O.Default(None))
    /** Database column phone SqlType(VARCHAR), Length(20,true) */
    val phone: Rep[String] = column[String]("phone", O.Length(20,varying=true))
    /** Database column city SqlType(VARCHAR), Length(50,true) */
    val city: Rep[String] = column[String]("city", O.Length(50,varying=true))
    /** Database column country SqlType(VARCHAR), Length(50,true) */
    val country: Rep[String] = column[String]("country", O.Length(50,varying=true))
    /** Database column notes SqlType(VARCHAR), Length(6,true), Default() */
    val notes: Rep[String] = column[String]("notes", O.Length(6,varying=true), O.Default(""))
    /** Database column SID SqlType(TINYINT UNSIGNED) */
    val sid: Rep[Byte] = column[Byte]("SID")
  }
  /** Collection-like TableQuery object for table CustomerList */
  lazy val CustomerList = new TableQuery(tag => new CustomerList(tag))

  /** Entity class storing rows of table Film
   *  @param filmId Database column film_id SqlType(SMALLINT UNSIGNED), AutoInc, PrimaryKey
   *  @param title Database column title SqlType(VARCHAR), Length(255,true)
   *  @param description Database column description SqlType(TEXT), Default(None)
   *  @param releaseYear Database column release_year SqlType(YEAR), Default(None)
   *  @param languageId Database column language_id SqlType(TINYINT UNSIGNED)
   *  @param originalLanguageId Database column original_language_id SqlType(TINYINT UNSIGNED), Default(None)
   *  @param rentalDuration Database column rental_duration SqlType(TINYINT UNSIGNED), Default(3)
   *  @param rentalRate Database column rental_rate SqlType(DECIMAL), Default(4.99)
   *  @param length Database column length SqlType(SMALLINT UNSIGNED), Default(None)
   *  @param replacementCost Database column replacement_cost SqlType(DECIMAL), Default(19.99)
   *  @param rating Database column rating SqlType(ENUM), Length(5,false), Default(Some(G))
   *  @param specialFeatures Database column special_features SqlType(SET), Length(54,false), Default(None)
   *  @param lastUpdate Database column last_update SqlType(TIMESTAMP) */
  final case class FilmRow(filmId: Short, title: String, description: Option[String] = None, releaseYear: Option[java.sql.Date] = None, languageId: Byte, originalLanguageId: Option[Byte] = None, rentalDuration: Byte = 3, rentalRate: scala.math.BigDecimal = scala.math.BigDecimal("4.99"), length: Option[Short] = None, replacementCost: scala.math.BigDecimal = scala.math.BigDecimal("19.99"), rating: Option[String] = Some("G"), specialFeatures: Option[String] = None, lastUpdate: java.sql.Timestamp)
  /** GetResult implicit for fetching FilmRow objects using plain SQL queries */
  implicit def GetResultFilmRow(implicit e0: GR[Short], e1: GR[String], e2: GR[Option[String]], e3: GR[Option[java.sql.Date]], e4: GR[Byte], e5: GR[Option[Byte]], e6: GR[scala.math.BigDecimal], e7: GR[Option[Short]], e8: GR[java.sql.Timestamp]): GR[FilmRow] = GR{
    prs => import prs._
    FilmRow.tupled((<<[Short], <<[String], <<?[String], <<?[java.sql.Date], <<[Byte], <<?[Byte], <<[Byte], <<[scala.math.BigDecimal], <<?[Short], <<[scala.math.BigDecimal], <<?[String], <<?[String], <<[java.sql.Timestamp]))
  }
  /** Table description of table film. Objects of this class serve as prototypes for rows in queries. */
  class Film(_tableTag: Tag) extends profile.api.Table[FilmRow](_tableTag, Some("sakila"), "film") {
    def * = (filmId, title, description, releaseYear, languageId, originalLanguageId, rentalDuration, rentalRate, length, replacementCost, rating, specialFeatures, lastUpdate) <> (FilmRow.tupled, FilmRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(filmId), Rep.Some(title), description, releaseYear, Rep.Some(languageId), originalLanguageId, Rep.Some(rentalDuration), Rep.Some(rentalRate), length, Rep.Some(replacementCost), rating, specialFeatures, Rep.Some(lastUpdate)).shaped.<>({r=>import r._; _1.map(_=> FilmRow.tupled((_1.get, _2.get, _3, _4, _5.get, _6, _7.get, _8.get, _9, _10.get, _11, _12, _13.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column film_id SqlType(SMALLINT UNSIGNED), AutoInc, PrimaryKey */
    val filmId: Rep[Short] = column[Short]("film_id", O.AutoInc, O.PrimaryKey)
    /** Database column title SqlType(VARCHAR), Length(255,true) */
    val title: Rep[String] = column[String]("title", O.Length(255,varying=true))
    /** Database column description SqlType(TEXT), Default(None) */
    val description: Rep[Option[String]] = column[Option[String]]("description", O.Default(None))
    /** Database column release_year SqlType(YEAR), Default(None) */
    val releaseYear: Rep[Option[java.sql.Date]] = column[Option[java.sql.Date]]("release_year", O.Default(None))
    /** Database column language_id SqlType(TINYINT UNSIGNED) */
    val languageId: Rep[Byte] = column[Byte]("language_id")
    /** Database column original_language_id SqlType(TINYINT UNSIGNED), Default(None) */
    val originalLanguageId: Rep[Option[Byte]] = column[Option[Byte]]("original_language_id", O.Default(None))
    /** Database column rental_duration SqlType(TINYINT UNSIGNED), Default(3) */
    val rentalDuration: Rep[Byte] = column[Byte]("rental_duration", O.Default(3))
    /** Database column rental_rate SqlType(DECIMAL), Default(4.99) */
    val rentalRate: Rep[scala.math.BigDecimal] = column[scala.math.BigDecimal]("rental_rate", O.Default(scala.math.BigDecimal("4.99")))
    /** Database column length SqlType(SMALLINT UNSIGNED), Default(None) */
    val length: Rep[Option[Short]] = column[Option[Short]]("length", O.Default(None))
    /** Database column replacement_cost SqlType(DECIMAL), Default(19.99) */
    val replacementCost: Rep[scala.math.BigDecimal] = column[scala.math.BigDecimal]("replacement_cost", O.Default(scala.math.BigDecimal("19.99")))
    /** Database column rating SqlType(ENUM), Length(5,false), Default(Some(G)) */
    val rating: Rep[Option[String]] = column[Option[String]]("rating", O.Length(5,varying=false), O.Default(Some("G")))
    /** Database column special_features SqlType(SET), Length(54,false), Default(None) */
    val specialFeatures: Rep[Option[String]] = column[Option[String]]("special_features", O.Length(54,varying=false), O.Default(None))
    /** Database column last_update SqlType(TIMESTAMP) */
    val lastUpdate: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("last_update")

    /** Foreign key referencing Language (database name fk_film_language) */
    lazy val languageFk1 = foreignKey("fk_film_language", languageId, Language)(r => r.languageId, onUpdate=ForeignKeyAction.Cascade, onDelete=ForeignKeyAction.NoAction)
    /** Foreign key referencing Language (database name fk_film_language_original) */
    lazy val languageFk2 = foreignKey("fk_film_language_original", originalLanguageId, Language)(r => Rep.Some(r.languageId), onUpdate=ForeignKeyAction.Cascade, onDelete=ForeignKeyAction.NoAction)

    /** Index over (title) (database name idx_title) */
    val index1 = index("idx_title", title)
  }
  /** Collection-like TableQuery object for table Film */
  lazy val Film = new TableQuery(tag => new Film(tag))

  /** Entity class storing rows of table FilmActor
   *  @param actorId Database column actor_id SqlType(SMALLINT UNSIGNED)
   *  @param filmId Database column film_id SqlType(SMALLINT UNSIGNED)
   *  @param lastUpdate Database column last_update SqlType(TIMESTAMP) */
  final case class FilmActorRow(actorId: Short, filmId: Short, lastUpdate: java.sql.Timestamp)
  /** GetResult implicit for fetching FilmActorRow objects using plain SQL queries */
  implicit def GetResultFilmActorRow(implicit e0: GR[Short], e1: GR[java.sql.Timestamp]): GR[FilmActorRow] = GR{
    prs => import prs._
    FilmActorRow.tupled((<<[Short], <<[Short], <<[java.sql.Timestamp]))
  }
  /** Table description of table film_actor. Objects of this class serve as prototypes for rows in queries. */
  class FilmActor(_tableTag: Tag) extends profile.api.Table[FilmActorRow](_tableTag, Some("sakila"), "film_actor") {
    def * = (actorId, filmId, lastUpdate) <> (FilmActorRow.tupled, FilmActorRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(actorId), Rep.Some(filmId), Rep.Some(lastUpdate)).shaped.<>({r=>import r._; _1.map(_=> FilmActorRow.tupled((_1.get, _2.get, _3.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column actor_id SqlType(SMALLINT UNSIGNED) */
    val actorId: Rep[Short] = column[Short]("actor_id")
    /** Database column film_id SqlType(SMALLINT UNSIGNED) */
    val filmId: Rep[Short] = column[Short]("film_id")
    /** Database column last_update SqlType(TIMESTAMP) */
    val lastUpdate: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("last_update")

    /** Primary key of FilmActor (database name film_actor_PK) */
    val pk = primaryKey("film_actor_PK", (actorId, filmId))

    /** Foreign key referencing Actor (database name fk_film_actor_actor) */
    lazy val actorFk = foreignKey("fk_film_actor_actor", actorId, Actor)(r => r.actorId, onUpdate=ForeignKeyAction.Cascade, onDelete=ForeignKeyAction.NoAction)
    /** Foreign key referencing Film (database name fk_film_actor_film) */
    lazy val filmFk = foreignKey("fk_film_actor_film", filmId, Film)(r => r.filmId, onUpdate=ForeignKeyAction.Cascade, onDelete=ForeignKeyAction.NoAction)
  }
  /** Collection-like TableQuery object for table FilmActor */
  lazy val FilmActor = new TableQuery(tag => new FilmActor(tag))

  /** Entity class storing rows of table FilmCategory
   *  @param filmId Database column film_id SqlType(SMALLINT UNSIGNED)
   *  @param categoryId Database column category_id SqlType(TINYINT UNSIGNED)
   *  @param lastUpdate Database column last_update SqlType(TIMESTAMP) */
  final case class FilmCategoryRow(filmId: Short, categoryId: Byte, lastUpdate: java.sql.Timestamp)
  /** GetResult implicit for fetching FilmCategoryRow objects using plain SQL queries */
  implicit def GetResultFilmCategoryRow(implicit e0: GR[Short], e1: GR[Byte], e2: GR[java.sql.Timestamp]): GR[FilmCategoryRow] = GR{
    prs => import prs._
    FilmCategoryRow.tupled((<<[Short], <<[Byte], <<[java.sql.Timestamp]))
  }
  /** Table description of table film_category. Objects of this class serve as prototypes for rows in queries. */
  class FilmCategory(_tableTag: Tag) extends profile.api.Table[FilmCategoryRow](_tableTag, Some("sakila"), "film_category") {
    def * = (filmId, categoryId, lastUpdate) <> (FilmCategoryRow.tupled, FilmCategoryRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(filmId), Rep.Some(categoryId), Rep.Some(lastUpdate)).shaped.<>({r=>import r._; _1.map(_=> FilmCategoryRow.tupled((_1.get, _2.get, _3.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column film_id SqlType(SMALLINT UNSIGNED) */
    val filmId: Rep[Short] = column[Short]("film_id")
    /** Database column category_id SqlType(TINYINT UNSIGNED) */
    val categoryId: Rep[Byte] = column[Byte]("category_id")
    /** Database column last_update SqlType(TIMESTAMP) */
    val lastUpdate: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("last_update")

    /** Primary key of FilmCategory (database name film_category_PK) */
    val pk = primaryKey("film_category_PK", (filmId, categoryId))

    /** Foreign key referencing Category (database name fk_film_category_category) */
    lazy val categoryFk = foreignKey("fk_film_category_category", categoryId, Category)(r => r.categoryId, onUpdate=ForeignKeyAction.Cascade, onDelete=ForeignKeyAction.NoAction)
    /** Foreign key referencing Film (database name fk_film_category_film) */
    lazy val filmFk = foreignKey("fk_film_category_film", filmId, Film)(r => r.filmId, onUpdate=ForeignKeyAction.Cascade, onDelete=ForeignKeyAction.NoAction)
  }
  /** Collection-like TableQuery object for table FilmCategory */
  lazy val FilmCategory = new TableQuery(tag => new FilmCategory(tag))

  /** Entity class storing rows of table FilmList
   *  @param fid Database column FID SqlType(SMALLINT UNSIGNED), Default(Some(0))
   *  @param title Database column title SqlType(VARCHAR), Length(255,true), Default(None)
   *  @param description Database column description SqlType(TEXT), Default(None)
   *  @param category Database column category SqlType(VARCHAR), Length(25,true)
   *  @param price Database column price SqlType(DECIMAL), Default(Some(4.99))
   *  @param length Database column length SqlType(SMALLINT UNSIGNED), Default(None)
   *  @param rating Database column rating SqlType(ENUM), Length(5,false), Default(Some(G))
   *  @param actors Database column actors SqlType(TEXT), Default(None) */
  final case class FilmListRow(fid: Option[Short] = Some(0), title: Option[String] = None, description: Option[String] = None, category: String, price: Option[scala.math.BigDecimal] = Some(scala.math.BigDecimal("4.99")), length: Option[Short] = None, rating: Option[String] = Some("G"), actors: Option[String] = None)
  /** GetResult implicit for fetching FilmListRow objects using plain SQL queries */
  implicit def GetResultFilmListRow(implicit e0: GR[Option[Short]], e1: GR[Option[String]], e2: GR[String], e3: GR[Option[scala.math.BigDecimal]]): GR[FilmListRow] = GR{
    prs => import prs._
    FilmListRow.tupled((<<?[Short], <<?[String], <<?[String], <<[String], <<?[scala.math.BigDecimal], <<?[Short], <<?[String], <<?[String]))
  }
  /** Table description of table film_list. Objects of this class serve as prototypes for rows in queries. */
  class FilmList(_tableTag: Tag) extends profile.api.Table[FilmListRow](_tableTag, Some("sakila"), "film_list") {
    def * = (fid, title, description, category, price, length, rating, actors) <> (FilmListRow.tupled, FilmListRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (fid, title, description, Rep.Some(category), price, length, rating, actors).shaped.<>({r=>import r._; _4.map(_=> FilmListRow.tupled((_1, _2, _3, _4.get, _5, _6, _7, _8)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column FID SqlType(SMALLINT UNSIGNED), Default(Some(0)) */
    val fid: Rep[Option[Short]] = column[Option[Short]]("FID", O.Default(Some(0)))
    /** Database column title SqlType(VARCHAR), Length(255,true), Default(None) */
    val title: Rep[Option[String]] = column[Option[String]]("title", O.Length(255,varying=true), O.Default(None))
    /** Database column description SqlType(TEXT), Default(None) */
    val description: Rep[Option[String]] = column[Option[String]]("description", O.Default(None))
    /** Database column category SqlType(VARCHAR), Length(25,true) */
    val category: Rep[String] = column[String]("category", O.Length(25,varying=true))
    /** Database column price SqlType(DECIMAL), Default(Some(4.99)) */
    val price: Rep[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("price", O.Default(Some(scala.math.BigDecimal("4.99"))))
    /** Database column length SqlType(SMALLINT UNSIGNED), Default(None) */
    val length: Rep[Option[Short]] = column[Option[Short]]("length", O.Default(None))
    /** Database column rating SqlType(ENUM), Length(5,false), Default(Some(G)) */
    val rating: Rep[Option[String]] = column[Option[String]]("rating", O.Length(5,varying=false), O.Default(Some("G")))
    /** Database column actors SqlType(TEXT), Default(None) */
    val actors: Rep[Option[String]] = column[Option[String]]("actors", O.Default(None))
  }
  /** Collection-like TableQuery object for table FilmList */
  lazy val FilmList = new TableQuery(tag => new FilmList(tag))

  /** Entity class storing rows of table FilmText
   *  @param filmId Database column film_id SqlType(SMALLINT), PrimaryKey
   *  @param title Database column title SqlType(VARCHAR), Length(255,true)
   *  @param description Database column description SqlType(TEXT), Default(None) */
  final case class FilmTextRow(filmId: Short, title: String, description: Option[String] = None)
  /** GetResult implicit for fetching FilmTextRow objects using plain SQL queries */
  implicit def GetResultFilmTextRow(implicit e0: GR[Short], e1: GR[String], e2: GR[Option[String]]): GR[FilmTextRow] = GR{
    prs => import prs._
    FilmTextRow.tupled((<<[Short], <<[String], <<?[String]))
  }
  /** Table description of table film_text. Objects of this class serve as prototypes for rows in queries. */
  class FilmText(_tableTag: Tag) extends profile.api.Table[FilmTextRow](_tableTag, Some("sakila"), "film_text") {
    def * = (filmId, title, description) <> (FilmTextRow.tupled, FilmTextRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(filmId), Rep.Some(title), description).shaped.<>({r=>import r._; _1.map(_=> FilmTextRow.tupled((_1.get, _2.get, _3)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column film_id SqlType(SMALLINT), PrimaryKey */
    val filmId: Rep[Short] = column[Short]("film_id", O.PrimaryKey)
    /** Database column title SqlType(VARCHAR), Length(255,true) */
    val title: Rep[String] = column[String]("title", O.Length(255,varying=true))
    /** Database column description SqlType(TEXT), Default(None) */
    val description: Rep[Option[String]] = column[Option[String]]("description", O.Default(None))

    /** Index over (title,description) (database name idx_title_description) */
    val index1 = index("idx_title_description", (title, description))
  }
  /** Collection-like TableQuery object for table FilmText */
  lazy val FilmText = new TableQuery(tag => new FilmText(tag))

  /** Entity class storing rows of table Inventory
   *  @param inventoryId Database column inventory_id SqlType(MEDIUMINT UNSIGNED), AutoInc, PrimaryKey
   *  @param filmId Database column film_id SqlType(SMALLINT UNSIGNED)
   *  @param storeId Database column store_id SqlType(TINYINT UNSIGNED)
   *  @param lastUpdate Database column last_update SqlType(TIMESTAMP) */
  final case class InventoryRow(inventoryId: Int, filmId: Short, storeId: Byte, lastUpdate: java.sql.Timestamp)
  /** GetResult implicit for fetching InventoryRow objects using plain SQL queries */
  implicit def GetResultInventoryRow(implicit e0: GR[Int], e1: GR[Short], e2: GR[Byte], e3: GR[java.sql.Timestamp]): GR[InventoryRow] = GR{
    prs => import prs._
    InventoryRow.tupled((<<[Int], <<[Short], <<[Byte], <<[java.sql.Timestamp]))
  }
  /** Table description of table inventory. Objects of this class serve as prototypes for rows in queries. */
  class Inventory(_tableTag: Tag) extends profile.api.Table[InventoryRow](_tableTag, Some("sakila"), "inventory") {
    def * = (inventoryId, filmId, storeId, lastUpdate) <> (InventoryRow.tupled, InventoryRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(inventoryId), Rep.Some(filmId), Rep.Some(storeId), Rep.Some(lastUpdate)).shaped.<>({r=>import r._; _1.map(_=> InventoryRow.tupled((_1.get, _2.get, _3.get, _4.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column inventory_id SqlType(MEDIUMINT UNSIGNED), AutoInc, PrimaryKey */
    val inventoryId: Rep[Int] = column[Int]("inventory_id", O.AutoInc, O.PrimaryKey)
    /** Database column film_id SqlType(SMALLINT UNSIGNED) */
    val filmId: Rep[Short] = column[Short]("film_id")
    /** Database column store_id SqlType(TINYINT UNSIGNED) */
    val storeId: Rep[Byte] = column[Byte]("store_id")
    /** Database column last_update SqlType(TIMESTAMP) */
    val lastUpdate: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("last_update")

    /** Foreign key referencing Film (database name fk_inventory_film) */
    lazy val filmFk = foreignKey("fk_inventory_film", filmId, Film)(r => r.filmId, onUpdate=ForeignKeyAction.Cascade, onDelete=ForeignKeyAction.NoAction)
    /** Foreign key referencing Store (database name fk_inventory_store) */
    lazy val storeFk = foreignKey("fk_inventory_store", storeId, Store)(r => r.storeId, onUpdate=ForeignKeyAction.Cascade, onDelete=ForeignKeyAction.NoAction)

    /** Index over (storeId,filmId) (database name idx_store_id_film_id) */
    val index1 = index("idx_store_id_film_id", (storeId, filmId))
  }
  /** Collection-like TableQuery object for table Inventory */
  lazy val Inventory = new TableQuery(tag => new Inventory(tag))

  /** Entity class storing rows of table Language
   *  @param languageId Database column language_id SqlType(TINYINT UNSIGNED), AutoInc, PrimaryKey
   *  @param name Database column name SqlType(CHAR), Length(20,false)
   *  @param lastUpdate Database column last_update SqlType(TIMESTAMP) */
  final case class LanguageRow(languageId: Byte, name: String, lastUpdate: java.sql.Timestamp)
  /** GetResult implicit for fetching LanguageRow objects using plain SQL queries */
  implicit def GetResultLanguageRow(implicit e0: GR[Byte], e1: GR[String], e2: GR[java.sql.Timestamp]): GR[LanguageRow] = GR{
    prs => import prs._
    LanguageRow.tupled((<<[Byte], <<[String], <<[java.sql.Timestamp]))
  }
  /** Table description of table language. Objects of this class serve as prototypes for rows in queries. */
  class Language(_tableTag: Tag) extends profile.api.Table[LanguageRow](_tableTag, Some("sakila"), "language") {
    def * = (languageId, name, lastUpdate) <> (LanguageRow.tupled, LanguageRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(languageId), Rep.Some(name), Rep.Some(lastUpdate)).shaped.<>({r=>import r._; _1.map(_=> LanguageRow.tupled((_1.get, _2.get, _3.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column language_id SqlType(TINYINT UNSIGNED), AutoInc, PrimaryKey */
    val languageId: Rep[Byte] = column[Byte]("language_id", O.AutoInc, O.PrimaryKey)
    /** Database column name SqlType(CHAR), Length(20,false) */
    val name: Rep[String] = column[String]("name", O.Length(20,varying=false))
    /** Database column last_update SqlType(TIMESTAMP) */
    val lastUpdate: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("last_update")
  }
  /** Collection-like TableQuery object for table Language */
  lazy val Language = new TableQuery(tag => new Language(tag))

  /** Entity class storing rows of table NicerButSlowerFilmList
   *  @param fid Database column FID SqlType(SMALLINT UNSIGNED), Default(Some(0))
   *  @param title Database column title SqlType(VARCHAR), Length(255,true), Default(None)
   *  @param description Database column description SqlType(TEXT), Default(None)
   *  @param category Database column category SqlType(VARCHAR), Length(25,true)
   *  @param price Database column price SqlType(DECIMAL), Default(Some(4.99))
   *  @param length Database column length SqlType(SMALLINT UNSIGNED), Default(None)
   *  @param rating Database column rating SqlType(ENUM), Length(5,false), Default(Some(G))
   *  @param actors Database column actors SqlType(TEXT), Default(None) */
  final case class NicerButSlowerFilmListRow(fid: Option[Short] = Some(0), title: Option[String] = None, description: Option[String] = None, category: String, price: Option[scala.math.BigDecimal] = Some(scala.math.BigDecimal("4.99")), length: Option[Short] = None, rating: Option[String] = Some("G"), actors: Option[String] = None)
  /** GetResult implicit for fetching NicerButSlowerFilmListRow objects using plain SQL queries */
  implicit def GetResultNicerButSlowerFilmListRow(implicit e0: GR[Option[Short]], e1: GR[Option[String]], e2: GR[String], e3: GR[Option[scala.math.BigDecimal]]): GR[NicerButSlowerFilmListRow] = GR{
    prs => import prs._
    NicerButSlowerFilmListRow.tupled((<<?[Short], <<?[String], <<?[String], <<[String], <<?[scala.math.BigDecimal], <<?[Short], <<?[String], <<?[String]))
  }
  /** Table description of table nicer_but_slower_film_list. Objects of this class serve as prototypes for rows in queries. */
  class NicerButSlowerFilmList(_tableTag: Tag) extends profile.api.Table[NicerButSlowerFilmListRow](_tableTag, Some("sakila"), "nicer_but_slower_film_list") {
    def * = (fid, title, description, category, price, length, rating, actors) <> (NicerButSlowerFilmListRow.tupled, NicerButSlowerFilmListRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (fid, title, description, Rep.Some(category), price, length, rating, actors).shaped.<>({r=>import r._; _4.map(_=> NicerButSlowerFilmListRow.tupled((_1, _2, _3, _4.get, _5, _6, _7, _8)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column FID SqlType(SMALLINT UNSIGNED), Default(Some(0)) */
    val fid: Rep[Option[Short]] = column[Option[Short]]("FID", O.Default(Some(0)))
    /** Database column title SqlType(VARCHAR), Length(255,true), Default(None) */
    val title: Rep[Option[String]] = column[Option[String]]("title", O.Length(255,varying=true), O.Default(None))
    /** Database column description SqlType(TEXT), Default(None) */
    val description: Rep[Option[String]] = column[Option[String]]("description", O.Default(None))
    /** Database column category SqlType(VARCHAR), Length(25,true) */
    val category: Rep[String] = column[String]("category", O.Length(25,varying=true))
    /** Database column price SqlType(DECIMAL), Default(Some(4.99)) */
    val price: Rep[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("price", O.Default(Some(scala.math.BigDecimal("4.99"))))
    /** Database column length SqlType(SMALLINT UNSIGNED), Default(None) */
    val length: Rep[Option[Short]] = column[Option[Short]]("length", O.Default(None))
    /** Database column rating SqlType(ENUM), Length(5,false), Default(Some(G)) */
    val rating: Rep[Option[String]] = column[Option[String]]("rating", O.Length(5,varying=false), O.Default(Some("G")))
    /** Database column actors SqlType(TEXT), Default(None) */
    val actors: Rep[Option[String]] = column[Option[String]]("actors", O.Default(None))
  }
  /** Collection-like TableQuery object for table NicerButSlowerFilmList */
  lazy val NicerButSlowerFilmList = new TableQuery(tag => new NicerButSlowerFilmList(tag))

  /** Entity class storing rows of table Payment
   *  @param paymentId Database column payment_id SqlType(SMALLINT UNSIGNED), AutoInc, PrimaryKey
   *  @param customerId Database column customer_id SqlType(SMALLINT UNSIGNED)
   *  @param staffId Database column staff_id SqlType(TINYINT UNSIGNED)
   *  @param rentalId Database column rental_id SqlType(INT), Default(None)
   *  @param amount Database column amount SqlType(DECIMAL)
   *  @param paymentDate Database column payment_date SqlType(DATETIME)
   *  @param lastUpdate Database column last_update SqlType(TIMESTAMP) */
  final case class PaymentRow(paymentId: Short, customerId: Short, staffId: Byte, rentalId: Option[Int] = None, amount: scala.math.BigDecimal, paymentDate: java.sql.Timestamp, lastUpdate: java.sql.Timestamp)
  /** GetResult implicit for fetching PaymentRow objects using plain SQL queries */
  implicit def GetResultPaymentRow(implicit e0: GR[Short], e1: GR[Byte], e2: GR[Option[Int]], e3: GR[scala.math.BigDecimal], e4: GR[java.sql.Timestamp]): GR[PaymentRow] = GR{
    prs => import prs._
    PaymentRow.tupled((<<[Short], <<[Short], <<[Byte], <<?[Int], <<[scala.math.BigDecimal], <<[java.sql.Timestamp], <<[java.sql.Timestamp]))
  }
  /** Table description of table payment. Objects of this class serve as prototypes for rows in queries. */
  class Payment(_tableTag: Tag) extends profile.api.Table[PaymentRow](_tableTag, Some("sakila"), "payment") {
    def * = (paymentId, customerId, staffId, rentalId, amount, paymentDate, lastUpdate) <> (PaymentRow.tupled, PaymentRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(paymentId), Rep.Some(customerId), Rep.Some(staffId), rentalId, Rep.Some(amount), Rep.Some(paymentDate), Rep.Some(lastUpdate)).shaped.<>({r=>import r._; _1.map(_=> PaymentRow.tupled((_1.get, _2.get, _3.get, _4, _5.get, _6.get, _7.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column payment_id SqlType(SMALLINT UNSIGNED), AutoInc, PrimaryKey */
    val paymentId: Rep[Short] = column[Short]("payment_id", O.AutoInc, O.PrimaryKey)
    /** Database column customer_id SqlType(SMALLINT UNSIGNED) */
    val customerId: Rep[Short] = column[Short]("customer_id")
    /** Database column staff_id SqlType(TINYINT UNSIGNED) */
    val staffId: Rep[Byte] = column[Byte]("staff_id")
    /** Database column rental_id SqlType(INT), Default(None) */
    val rentalId: Rep[Option[Int]] = column[Option[Int]]("rental_id", O.Default(None))
    /** Database column amount SqlType(DECIMAL) */
    val amount: Rep[scala.math.BigDecimal] = column[scala.math.BigDecimal]("amount")
    /** Database column payment_date SqlType(DATETIME) */
    val paymentDate: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("payment_date")
    /** Database column last_update SqlType(TIMESTAMP) */
    val lastUpdate: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("last_update")

    /** Foreign key referencing Customer (database name fk_payment_customer) */
    lazy val customerFk = foreignKey("fk_payment_customer", customerId, Customer)(r => r.customerId, onUpdate=ForeignKeyAction.Cascade, onDelete=ForeignKeyAction.NoAction)
    /** Foreign key referencing Rental (database name fk_payment_rental) */
    lazy val rentalFk = foreignKey("fk_payment_rental", rentalId, Rental)(r => Rep.Some(r.rentalId), onUpdate=ForeignKeyAction.Cascade, onDelete=ForeignKeyAction.SetNull)
    /** Foreign key referencing Staff (database name fk_payment_staff) */
    lazy val staffFk = foreignKey("fk_payment_staff", staffId, Staff)(r => r.staffId, onUpdate=ForeignKeyAction.Cascade, onDelete=ForeignKeyAction.NoAction)
  }
  /** Collection-like TableQuery object for table Payment */
  lazy val Payment = new TableQuery(tag => new Payment(tag))

  /** Entity class storing rows of table Rental
   *  @param rentalId Database column rental_id SqlType(INT), AutoInc, PrimaryKey
   *  @param rentalDate Database column rental_date SqlType(DATETIME)
   *  @param inventoryId Database column inventory_id SqlType(MEDIUMINT UNSIGNED)
   *  @param customerId Database column customer_id SqlType(SMALLINT UNSIGNED)
   *  @param returnDate Database column return_date SqlType(DATETIME), Default(None)
   *  @param staffId Database column staff_id SqlType(TINYINT UNSIGNED)
   *  @param lastUpdate Database column last_update SqlType(TIMESTAMP) */
  final case class RentalRow(rentalId: Int, rentalDate: java.sql.Timestamp, inventoryId: Int, customerId: Short, returnDate: Option[java.sql.Timestamp] = None, staffId: Byte, lastUpdate: java.sql.Timestamp)
  /** GetResult implicit for fetching RentalRow objects using plain SQL queries */
  implicit def GetResultRentalRow(implicit e0: GR[Int], e1: GR[java.sql.Timestamp], e2: GR[Short], e3: GR[Option[java.sql.Timestamp]], e4: GR[Byte]): GR[RentalRow] = GR{
    prs => import prs._
    RentalRow.tupled((<<[Int], <<[java.sql.Timestamp], <<[Int], <<[Short], <<?[java.sql.Timestamp], <<[Byte], <<[java.sql.Timestamp]))
  }
  /** Table description of table rental. Objects of this class serve as prototypes for rows in queries. */
  class Rental(_tableTag: Tag) extends profile.api.Table[RentalRow](_tableTag, Some("sakila"), "rental") {
    def * = (rentalId, rentalDate, inventoryId, customerId, returnDate, staffId, lastUpdate) <> (RentalRow.tupled, RentalRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(rentalId), Rep.Some(rentalDate), Rep.Some(inventoryId), Rep.Some(customerId), returnDate, Rep.Some(staffId), Rep.Some(lastUpdate)).shaped.<>({r=>import r._; _1.map(_=> RentalRow.tupled((_1.get, _2.get, _3.get, _4.get, _5, _6.get, _7.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column rental_id SqlType(INT), AutoInc, PrimaryKey */
    val rentalId: Rep[Int] = column[Int]("rental_id", O.AutoInc, O.PrimaryKey)
    /** Database column rental_date SqlType(DATETIME) */
    val rentalDate: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("rental_date")
    /** Database column inventory_id SqlType(MEDIUMINT UNSIGNED) */
    val inventoryId: Rep[Int] = column[Int]("inventory_id")
    /** Database column customer_id SqlType(SMALLINT UNSIGNED) */
    val customerId: Rep[Short] = column[Short]("customer_id")
    /** Database column return_date SqlType(DATETIME), Default(None) */
    val returnDate: Rep[Option[java.sql.Timestamp]] = column[Option[java.sql.Timestamp]]("return_date", O.Default(None))
    /** Database column staff_id SqlType(TINYINT UNSIGNED) */
    val staffId: Rep[Byte] = column[Byte]("staff_id")
    /** Database column last_update SqlType(TIMESTAMP) */
    val lastUpdate: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("last_update")

    /** Foreign key referencing Customer (database name fk_rental_customer) */
    lazy val customerFk = foreignKey("fk_rental_customer", customerId, Customer)(r => r.customerId, onUpdate=ForeignKeyAction.Cascade, onDelete=ForeignKeyAction.NoAction)
    /** Foreign key referencing Inventory (database name fk_rental_inventory) */
    lazy val inventoryFk = foreignKey("fk_rental_inventory", inventoryId, Inventory)(r => r.inventoryId, onUpdate=ForeignKeyAction.Cascade, onDelete=ForeignKeyAction.NoAction)
    /** Foreign key referencing Staff (database name fk_rental_staff) */
    lazy val staffFk = foreignKey("fk_rental_staff", staffId, Staff)(r => r.staffId, onUpdate=ForeignKeyAction.Cascade, onDelete=ForeignKeyAction.NoAction)

    /** Uniqueness Index over (rentalDate,inventoryId,customerId) (database name rental_date) */
    val index1 = index("rental_date", (rentalDate, inventoryId, customerId), unique=true)
  }
  /** Collection-like TableQuery object for table Rental */
  lazy val Rental = new TableQuery(tag => new Rental(tag))

  /** Entity class storing rows of table SalesByFilmCategory
   *  @param category Database column category SqlType(VARCHAR), Length(25,true)
   *  @param totalSales Database column total_sales SqlType(DECIMAL), Default(None) */
  final case class SalesByFilmCategoryRow(category: String, totalSales: Option[scala.math.BigDecimal] = None)
  /** GetResult implicit for fetching SalesByFilmCategoryRow objects using plain SQL queries */
  implicit def GetResultSalesByFilmCategoryRow(implicit e0: GR[String], e1: GR[Option[scala.math.BigDecimal]]): GR[SalesByFilmCategoryRow] = GR{
    prs => import prs._
    SalesByFilmCategoryRow.tupled((<<[String], <<?[scala.math.BigDecimal]))
  }
  /** Table description of table sales_by_film_category. Objects of this class serve as prototypes for rows in queries. */
  class SalesByFilmCategory(_tableTag: Tag) extends profile.api.Table[SalesByFilmCategoryRow](_tableTag, Some("sakila"), "sales_by_film_category") {
    def * = (category, totalSales) <> (SalesByFilmCategoryRow.tupled, SalesByFilmCategoryRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(category), totalSales).shaped.<>({r=>import r._; _1.map(_=> SalesByFilmCategoryRow.tupled((_1.get, _2)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column category SqlType(VARCHAR), Length(25,true) */
    val category: Rep[String] = column[String]("category", O.Length(25,varying=true))
    /** Database column total_sales SqlType(DECIMAL), Default(None) */
    val totalSales: Rep[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("total_sales", O.Default(None))
  }
  /** Collection-like TableQuery object for table SalesByFilmCategory */
  lazy val SalesByFilmCategory = new TableQuery(tag => new SalesByFilmCategory(tag))

  /** Entity class storing rows of table SalesByStore
   *  @param store Database column store SqlType(VARCHAR), Length(101,true), Default(None)
   *  @param manager Database column manager SqlType(VARCHAR), Length(91,true), Default(None)
   *  @param totalSales Database column total_sales SqlType(DECIMAL), Default(None) */
  final case class SalesByStoreRow(store: Option[String] = None, manager: Option[String] = None, totalSales: Option[scala.math.BigDecimal] = None)
  /** GetResult implicit for fetching SalesByStoreRow objects using plain SQL queries */
  implicit def GetResultSalesByStoreRow(implicit e0: GR[Option[String]], e1: GR[Option[scala.math.BigDecimal]]): GR[SalesByStoreRow] = GR{
    prs => import prs._
    SalesByStoreRow.tupled((<<?[String], <<?[String], <<?[scala.math.BigDecimal]))
  }
  /** Table description of table sales_by_store. Objects of this class serve as prototypes for rows in queries. */
  class SalesByStore(_tableTag: Tag) extends profile.api.Table[SalesByStoreRow](_tableTag, Some("sakila"), "sales_by_store") {
    def * = (store, manager, totalSales) <> (SalesByStoreRow.tupled, SalesByStoreRow.unapply)

    /** Database column store SqlType(VARCHAR), Length(101,true), Default(None) */
    val store: Rep[Option[String]] = column[Option[String]]("store", O.Length(101,varying=true), O.Default(None))
    /** Database column manager SqlType(VARCHAR), Length(91,true), Default(None) */
    val manager: Rep[Option[String]] = column[Option[String]]("manager", O.Length(91,varying=true), O.Default(None))
    /** Database column total_sales SqlType(DECIMAL), Default(None) */
    val totalSales: Rep[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("total_sales", O.Default(None))
  }
  /** Collection-like TableQuery object for table SalesByStore */
  lazy val SalesByStore = new TableQuery(tag => new SalesByStore(tag))

  /** Entity class storing rows of table Staff
   *  @param staffId Database column staff_id SqlType(TINYINT UNSIGNED), AutoInc, PrimaryKey
   *  @param firstName Database column first_name SqlType(VARCHAR), Length(45,true)
   *  @param lastName Database column last_name SqlType(VARCHAR), Length(45,true)
   *  @param addressId Database column address_id SqlType(SMALLINT UNSIGNED)
   *  @param picture Database column picture SqlType(BLOB), Default(None)
   *  @param email Database column email SqlType(VARCHAR), Length(50,true), Default(None)
   *  @param storeId Database column store_id SqlType(TINYINT UNSIGNED)
   *  @param active Database column active SqlType(BIT), Default(true)
   *  @param username Database column username SqlType(VARCHAR), Length(16,true)
   *  @param password Database column password SqlType(VARCHAR), Length(40,true), Default(None)
   *  @param lastUpdate Database column last_update SqlType(TIMESTAMP) */
  final case class StaffRow(staffId: Byte, firstName: String, lastName: String, addressId: Short, picture: Option[java.sql.Blob] = None, email: Option[String] = None, storeId: Byte, active: Boolean = true, username: String, password: Option[String] = None, lastUpdate: java.sql.Timestamp)
  /** GetResult implicit for fetching StaffRow objects using plain SQL queries */
  implicit def GetResultStaffRow(implicit e0: GR[Byte], e1: GR[String], e2: GR[Short], e3: GR[Option[java.sql.Blob]], e4: GR[Option[String]], e5: GR[Boolean], e6: GR[java.sql.Timestamp]): GR[StaffRow] = GR{
    prs => import prs._
    StaffRow.tupled((<<[Byte], <<[String], <<[String], <<[Short], <<?[java.sql.Blob], <<?[String], <<[Byte], <<[Boolean], <<[String], <<?[String], <<[java.sql.Timestamp]))
  }
  /** Table description of table staff. Objects of this class serve as prototypes for rows in queries. */
  class Staff(_tableTag: Tag) extends profile.api.Table[StaffRow](_tableTag, Some("sakila"), "staff") {
    def * = (staffId, firstName, lastName, addressId, picture, email, storeId, active, username, password, lastUpdate) <> (StaffRow.tupled, StaffRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(staffId), Rep.Some(firstName), Rep.Some(lastName), Rep.Some(addressId), picture, email, Rep.Some(storeId), Rep.Some(active), Rep.Some(username), password, Rep.Some(lastUpdate)).shaped.<>({r=>import r._; _1.map(_=> StaffRow.tupled((_1.get, _2.get, _3.get, _4.get, _5, _6, _7.get, _8.get, _9.get, _10, _11.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column staff_id SqlType(TINYINT UNSIGNED), AutoInc, PrimaryKey */
    val staffId: Rep[Byte] = column[Byte]("staff_id", O.AutoInc, O.PrimaryKey)
    /** Database column first_name SqlType(VARCHAR), Length(45,true) */
    val firstName: Rep[String] = column[String]("first_name", O.Length(45,varying=true))
    /** Database column last_name SqlType(VARCHAR), Length(45,true) */
    val lastName: Rep[String] = column[String]("last_name", O.Length(45,varying=true))
    /** Database column address_id SqlType(SMALLINT UNSIGNED) */
    val addressId: Rep[Short] = column[Short]("address_id")
    /** Database column picture SqlType(BLOB), Default(None) */
    val picture: Rep[Option[java.sql.Blob]] = column[Option[java.sql.Blob]]("picture", O.Default(None))
    /** Database column email SqlType(VARCHAR), Length(50,true), Default(None) */
    val email: Rep[Option[String]] = column[Option[String]]("email", O.Length(50,varying=true), O.Default(None))
    /** Database column store_id SqlType(TINYINT UNSIGNED) */
    val storeId: Rep[Byte] = column[Byte]("store_id")
    /** Database column active SqlType(BIT), Default(true) */
    val active: Rep[Boolean] = column[Boolean]("active", O.Default(true))
    /** Database column username SqlType(VARCHAR), Length(16,true) */
    val username: Rep[String] = column[String]("username", O.Length(16,varying=true))
    /** Database column password SqlType(VARCHAR), Length(40,true), Default(None) */
    val password: Rep[Option[String]] = column[Option[String]]("password", O.Length(40,varying=true), O.Default(None))
    /** Database column last_update SqlType(TIMESTAMP) */
    val lastUpdate: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("last_update")

    /** Foreign key referencing Address (database name fk_staff_address) */
    lazy val addressFk = foreignKey("fk_staff_address", addressId, Address)(r => r.addressId, onUpdate=ForeignKeyAction.Cascade, onDelete=ForeignKeyAction.NoAction)
    /** Foreign key referencing Store (database name fk_staff_store) */
    lazy val storeFk = foreignKey("fk_staff_store", storeId, Store)(r => r.storeId, onUpdate=ForeignKeyAction.Cascade, onDelete=ForeignKeyAction.NoAction)
  }
  /** Collection-like TableQuery object for table Staff */
  lazy val Staff = new TableQuery(tag => new Staff(tag))

  /** Entity class storing rows of table StaffList
   *  @param id Database column ID SqlType(TINYINT UNSIGNED), Default(0)
   *  @param name Database column name SqlType(VARCHAR), Length(91,true), Default(None)
   *  @param address Database column address SqlType(VARCHAR), Length(50,true)
   *  @param `zip code` Database column zip code SqlType(VARCHAR), Length(10,true), Default(None)
   *  @param phone Database column phone SqlType(VARCHAR), Length(20,true)
   *  @param city Database column city SqlType(VARCHAR), Length(50,true)
   *  @param country Database column country SqlType(VARCHAR), Length(50,true)
   *  @param sid Database column SID SqlType(TINYINT UNSIGNED) */
  final case class StaffListRow(id: Byte = 0, name: Option[String] = None, address: String, `zip code`: Option[String] = None, phone: String, city: String, country: String, sid: Byte)
  /** GetResult implicit for fetching StaffListRow objects using plain SQL queries */
  implicit def GetResultStaffListRow(implicit e0: GR[Byte], e1: GR[Option[String]], e2: GR[String]): GR[StaffListRow] = GR{
    prs => import prs._
    StaffListRow.tupled((<<[Byte], <<?[String], <<[String], <<?[String], <<[String], <<[String], <<[String], <<[Byte]))
  }
  /** Table description of table staff_list. Objects of this class serve as prototypes for rows in queries. */
  class StaffList(_tableTag: Tag) extends profile.api.Table[StaffListRow](_tableTag, Some("sakila"), "staff_list") {
    def * = (id, name, address, `zip code`, phone, city, country, sid) <> (StaffListRow.tupled, StaffListRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), name, Rep.Some(address), `zip code`, Rep.Some(phone), Rep.Some(city), Rep.Some(country), Rep.Some(sid)).shaped.<>({r=>import r._; _1.map(_=> StaffListRow.tupled((_1.get, _2, _3.get, _4, _5.get, _6.get, _7.get, _8.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column ID SqlType(TINYINT UNSIGNED), Default(0) */
    val id: Rep[Byte] = column[Byte]("ID", O.Default(0))
    /** Database column name SqlType(VARCHAR), Length(91,true), Default(None) */
    val name: Rep[Option[String]] = column[Option[String]]("name", O.Length(91,varying=true), O.Default(None))
    /** Database column address SqlType(VARCHAR), Length(50,true) */
    val address: Rep[String] = column[String]("address", O.Length(50,varying=true))
    /** Database column zip code SqlType(VARCHAR), Length(10,true), Default(None) */
    val `zip code`: Rep[Option[String]] = column[Option[String]]("zip code", O.Length(10,varying=true), O.Default(None))
    /** Database column phone SqlType(VARCHAR), Length(20,true) */
    val phone: Rep[String] = column[String]("phone", O.Length(20,varying=true))
    /** Database column city SqlType(VARCHAR), Length(50,true) */
    val city: Rep[String] = column[String]("city", O.Length(50,varying=true))
    /** Database column country SqlType(VARCHAR), Length(50,true) */
    val country: Rep[String] = column[String]("country", O.Length(50,varying=true))
    /** Database column SID SqlType(TINYINT UNSIGNED) */
    val sid: Rep[Byte] = column[Byte]("SID")
  }
  /** Collection-like TableQuery object for table StaffList */
  lazy val StaffList = new TableQuery(tag => new StaffList(tag))

  /** Entity class storing rows of table Store
   *  @param storeId Database column store_id SqlType(TINYINT UNSIGNED), AutoInc, PrimaryKey
   *  @param managerStaffId Database column manager_staff_id SqlType(TINYINT UNSIGNED)
   *  @param addressId Database column address_id SqlType(SMALLINT UNSIGNED)
   *  @param lastUpdate Database column last_update SqlType(TIMESTAMP) */
  final case class StoreRow(storeId: Byte, managerStaffId: Byte, addressId: Short, lastUpdate: java.sql.Timestamp)
  /** GetResult implicit for fetching StoreRow objects using plain SQL queries */
  implicit def GetResultStoreRow(implicit e0: GR[Byte], e1: GR[Short], e2: GR[java.sql.Timestamp]): GR[StoreRow] = GR{
    prs => import prs._
    StoreRow.tupled((<<[Byte], <<[Byte], <<[Short], <<[java.sql.Timestamp]))
  }
  /** Table description of table store. Objects of this class serve as prototypes for rows in queries. */
  class Store(_tableTag: Tag) extends profile.api.Table[StoreRow](_tableTag, Some("sakila"), "store") {
    def * = (storeId, managerStaffId, addressId, lastUpdate) <> (StoreRow.tupled, StoreRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(storeId), Rep.Some(managerStaffId), Rep.Some(addressId), Rep.Some(lastUpdate)).shaped.<>({r=>import r._; _1.map(_=> StoreRow.tupled((_1.get, _2.get, _3.get, _4.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column store_id SqlType(TINYINT UNSIGNED), AutoInc, PrimaryKey */
    val storeId: Rep[Byte] = column[Byte]("store_id", O.AutoInc, O.PrimaryKey)
    /** Database column manager_staff_id SqlType(TINYINT UNSIGNED) */
    val managerStaffId: Rep[Byte] = column[Byte]("manager_staff_id")
    /** Database column address_id SqlType(SMALLINT UNSIGNED) */
    val addressId: Rep[Short] = column[Short]("address_id")
    /** Database column last_update SqlType(TIMESTAMP) */
    val lastUpdate: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("last_update")

    /** Foreign key referencing Address (database name fk_store_address) */
    lazy val addressFk = foreignKey("fk_store_address", addressId, Address)(r => r.addressId, onUpdate=ForeignKeyAction.Cascade, onDelete=ForeignKeyAction.NoAction)
    /** Foreign key referencing Staff (database name fk_store_staff) */
    lazy val staffFk = foreignKey("fk_store_staff", managerStaffId, Staff)(r => r.staffId, onUpdate=ForeignKeyAction.Cascade, onDelete=ForeignKeyAction.NoAction)

    /** Uniqueness Index over (managerStaffId) (database name idx_unique_manager) */
    val index1 = index("idx_unique_manager", managerStaffId, unique=true)
  }
  /** Collection-like TableQuery object for table Store */
  lazy val Store = new TableQuery(tag => new Store(tag))
}
