package pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class JsonPlaceHolderPojo {
    //   Pojo Class icin 4 adim gerekli

    // 1. PRIVATE VERIABLE

        private  Integer userId;
        private  String title;
        private  Boolean completed;

    // 2. Paramatreli ve parametresiz Constructor olustur

        public JsonPlaceHolderPojo(Integer userId, String title, Boolean completed) {
            this.userId = userId;
            this.title = title;
            this.completed = completed;
        }

        public JsonPlaceHolderPojo() {
        }

    // 3. Pablic getter ve setter methodlari olusutur

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }


    // 4. to String() methodu olustur


    @Override
    public String toString() {
        return "JsonPlaceHolderPojo{" +
                "userId=" + userId +
                ", title='" + title + '\'' +
                ", completed=" + completed +
                '}';
    }
}

/*
  {
             "userId": 55,
             "title": "Tidy your room",
             "completed": false
           }
 */