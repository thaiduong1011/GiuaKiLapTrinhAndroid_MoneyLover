using System;
using System.Collections.Generic;
using System.Data.SqlClient;
using System.Linq;
using System.Web.Http;
using ASPWebAPI.Models;

namespace ASPWebAPI.Controllers
{

    public class MoneyLogController : ApiController
    {
        [HttpGet]
        public IEnumerable<MoneylogDB> getList()
        {
            using (QuanLyThuChiEntities entities = new QuanLyThuChiEntities())
            {
                return entities.MoneylogDBs.ToList();
            }
          
        }

        [HttpGet]
        public MoneylogDB getById(int id)
        {
            using (QuanLyThuChiEntities entities = new QuanLyThuChiEntities())
            {
                return entities.MoneylogDBs.FirstOrDefault(e => e.id == id);
            }
        }

        [HttpPost]
        public bool insertLog(String name, int amount, int type, String note)
        {
            try
            {
                var cnnString = System.Configuration.ConfigurationManager.ConnectionStrings["QuanLyThuChiEntities"].ConnectionString;
                var command = "insert into MoneylogDB(name, amount, type, note) values(@name,@amount,@type,@note)";
                using (SqlConnection cnn = new SqlConnection(cnnString))
                {
                    using (SqlCommand cmd = new SqlCommand(command, cnn))
                    {
                        cmd.Parameters.AddWithValue("@name", name);
                        cmd.Parameters.AddWithValue("@amount", amount);
                        cmd.Parameters.AddWithValue("@type", type);
                        cmd.Parameters.AddWithValue("@note", note);

                        cnn.Open();
                        cmd.ExecuteNonQuery();
                    }
                }
                return true;           
                
            }
            catch (Exception)
            {
               return false;
            }


        }

        /*[HttpGet]
        public List<object> statistic(int type, int type_stat)
        {
            var cnnString = System.Configuration.ConfigurationManager.ConnectionStrings["QuanLyThuChiEntities"].ConnectionString;
            SqlConnection cnn = new SqlConnection(cnnString);
            cnn.Open();
            DateTime dateTime = DateTime.Today;
            //by day
            var command = "";
            // 1: theo ngay, 2: theo thang, 3: theo quy. 4: theo nam
            if (type_stat == 1)
            {
                command = "select * from MoneylogDB where DATEPART(YEAR, created_at) = @year and DATEPART(MONTH, created_at) = @month and DATEPART(DAY, created_at) = @day";
            }

            if (type_stat == 1)
            {
                command = "select * from MoneylogDB where DATEPART(DAY, created_at) = @day and type = @type";
          
            }
            else if (type_stat == 2)
            {
                command = "select * from MoneylogDB where DATEPART(YEAR, created_at) = @year and DATEPART(MONTH, created_at) = @month";
            }
            else if (type_stat == 3)
            {
                command = "select * from MoneylogDB where DATEPART(YEAR, created_at) = @year and DATEPART(QUARTER, created_at) = @quarter";
            }
            else
            {
                command = "select * from MoneylogDB where DATEPART(YEAR, created_at) = @year";
            }

            SqlCommand cmd = new SqlCommand(command, cnn);
            if (type_stat == 1)
            {
                cmd.Parameters.AddWithValue("@year", dateTime.ToString("yyyy"));
                cmd.Parameters.AddWithValue("@month", dateTime.ToString("MM"));
                cmd.Parameters.AddWithValue("@day", dateTime.ToString("dd"));
                cmd.Parameters.AddWithValue("@type", dateTime.ToString("type"));
            }
            else if (type_stat == 2)
            {
                cmd.Parameters.AddWithValue("@year", dateTime.ToString("yyyy"));
                cmd.Parameters.AddWithValue("@month", dateTime.ToString("MM"));
            }
            else if (type_stat == 3)
            {
                cmd.Parameters.AddWithValue("@year", dateTime.ToString("yyyy"));
                int quarter = (DateTime.Today.Month - 1) / 3 + 1;
                cmd.Parameters.AddWithValue("@quarter", quarter);
            }
            else
            {
                cmd.Parameters.AddWithValue("@year", dateTime.ToString("yyyy"));
            }

            SqlDataReader reader = cmd.ExecuteReader();
            
            List<object> moneylog = new List<object>();
            
            while (reader.Read())
            {
                moneylog.Add(new
                {
                    id = reader["id"],
                    name = reader["name"],
                    amount = reader["amount"],
                    type = reader["type"],
                    note = reader["note"],
                    created_at = reader["created_at"]
                });

            }
           return moneylog.ToList();
        
        }*/
    }

    
}









