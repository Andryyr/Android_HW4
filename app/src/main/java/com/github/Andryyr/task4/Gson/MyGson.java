package com.github.Andryyr.task4.Gson;

import java.util.List;

public class MyGson {

    private int total;
    private int total_pages;
    private List<ResultsBean> results;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getTotal_pages() {
        return total_pages;
    }

    public void setTotal_pages(int total_pages) {
        this.total_pages = total_pages;
    }

    public List<ResultsBean> getResults() {
        return results;
    }

    public void setResults(List<ResultsBean> results) {
        this.results = results;
    }

    public static class ResultsBean {


        private String id;
        private String created_at;
        private String updated_at;
        private int width;
        private int height;
        private String color;
        private String description;
        private UrlsBean urls;
        private LinksBean links;
        private boolean sponsored;
        private Object sponsored_by;
        private Object sponsored_impressions_id;
        private int likes;
        private boolean liked_by_user;
        private Object slug;
        private UserBean user;
        private List<?> categories;
        private List<?> current_user_collections;
        private List<TagsBean> tags;
        private List<PhotoTagsBean> photo_tags;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getCreated_at() {
            return created_at;
        }

        public void setCreated_at(String created_at) {
            this.created_at = created_at;
        }

        public String getUpdated_at() {
            return updated_at;
        }

        public void setUpdated_at(String updated_at) {
            this.updated_at = updated_at;
        }

        public int getWidth() {
            return width;
        }

        public void setWidth(int width) {
            this.width = width;
        }

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public UrlsBean getUrls() {
            return urls;
        }

        public void setUrls(UrlsBean urls) {
            this.urls = urls;
        }

        public LinksBean getLinks() {
            return links;
        }

        public void setLinks(LinksBean links) {
            this.links = links;
        }

        public boolean isSponsored() {
            return sponsored;
        }

        public void setSponsored(boolean sponsored) {
            this.sponsored = sponsored;
        }

        public Object getSponsored_by() {
            return sponsored_by;
        }

        public void setSponsored_by(Object sponsored_by) {
            this.sponsored_by = sponsored_by;
        }

        public Object getSponsored_impressions_id() {
            return sponsored_impressions_id;
        }

        public void setSponsored_impressions_id(Object sponsored_impressions_id) {
            this.sponsored_impressions_id = sponsored_impressions_id;
        }

        public int getLikes() {
            return likes;
        }

        public void setLikes(int likes) {
            this.likes = likes;
        }

        public boolean isLiked_by_user() {
            return liked_by_user;
        }

        public void setLiked_by_user(boolean liked_by_user) {
            this.liked_by_user = liked_by_user;
        }

        public Object getSlug() {
            return slug;
        }

        public void setSlug(Object slug) {
            this.slug = slug;
        }

        public UserBean getUser() {
            return user;
        }

        public void setUser(UserBean user) {
            this.user = user;
        }

        public List<?> getCategories() {
            return categories;
        }

        public void setCategories(List<?> categories) {
            this.categories = categories;
        }

        public List<?> getCurrent_user_collections() {
            return current_user_collections;
        }

        public void setCurrent_user_collections(List<?> current_user_collections) {
            this.current_user_collections = current_user_collections;
        }

        public List<TagsBean> getTags() {
            return tags;
        }

        public void setTags(List<TagsBean> tags) {
            this.tags = tags;
        }

        public List<PhotoTagsBean> getPhoto_tags() {
            return photo_tags;
        }

        public void setPhoto_tags(List<PhotoTagsBean> photo_tags) {
            this.photo_tags = photo_tags;
        }

        public static class UrlsBean {

            private String raw;
            private String full;
            private String regular;
            private String small;
            private String thumb;

            public String getRaw() {
                return raw;
            }

            public void setRaw(String raw) {
                this.raw = raw;
            }

            public String getFull() {
                return full;
            }

            public void setFull(String full) {
                this.full = full;
            }

            public String getRegular() {
                return regular;
            }

            public void setRegular(String regular) {
                this.regular = regular;
            }

            public String getSmall() {
                return small;
            }

            public void setSmall(String small) {
                this.small = small;
            }

            public String getThumb() {
                return thumb;
            }

            public void setThumb(String thumb) {
                this.thumb = thumb;
            }
        }

        public static class LinksBean {
            /**
             * self : https://api.unsplash.com/photos/70l1tDAI6rM
             * html : https://unsplash.com/photos/70l1tDAI6rM
             * download : https://unsplash.com/photos/70l1tDAI6rM/download
             * download_location : https://api.unsplash.com/photos/70l1tDAI6rM/download
             */

            private String self;
            private String html;
            private String download;
            private String download_location;

            public String getSelf() {
                return self;
            }

            public void setSelf(String self) {
                this.self = self;
            }

            public String getHtml() {
                return html;
            }

            public void setHtml(String html) {
                this.html = html;
            }

            public String getDownload() {
                return download;
            }

            public void setDownload(String download) {
                this.download = download;
            }

            public String getDownload_location() {
                return download_location;
            }

            public void setDownload_location(String download_location) {
                this.download_location = download_location;
            }
        }

        public static class UserBean {
            /**
             * id : Ib8exzXFC2Y
             * updated_at : 2018-10-26T11:23:51-04:00
             * username : chrisleeiam
             * name : Chris Lee
             * first_name : Chris
             * last_name : Lee
             * twitter_username : chrisleeiam
             * portfolio_url : null
             * bio : null
             * location : MX
             * links : {"self":"https://api.unsplash.com/users/chrisleeiam","html":"https://unsplash.com/@chrisleeiam","photos":"https://api.unsplash.com/users/chrisleeiam/photos","likes":"https://api.unsplash.com/users/chrisleeiam/likes","portfolio":"https://api.unsplash.com/users/chrisleeiam/portfolio","following":"https://api.unsplash.com/users/chrisleeiam/following","followers":"https://api.unsplash.com/users/chrisleeiam/followers"}
             * profile_image : {"small":"https://images.unsplash.com/profile-1444150880999-8042a8ce0979?ixlib=rb-0.3.5&q=80&fm=jpg&crop=faces&cs=tinysrgb&fit=crop&h=32&w=32&s=a19248eb27010a89557b8976bc63dbbc","medium":"https://images.unsplash.com/profile-1444150880999-8042a8ce0979?ixlib=rb-0.3.5&q=80&fm=jpg&crop=faces&cs=tinysrgb&fit=crop&h=64&w=64&s=f0c7f03e3eb53cf672e41335d1ae78b5","large":"https://images.unsplash.com/profile-1444150880999-8042a8ce0979?ixlib=rb-0.3.5&q=80&fm=jpg&crop=faces&cs=tinysrgb&fit=crop&h=128&w=128&s=0e5c358a66770755f016bca86f02886c"}
             * instagram_username : chrisleeiam
             * total_collections : 0
             * total_likes : 10
             * total_photos : 4
             * accepted_tos : false
             */

            private String id;
            private String updated_at;
            private String username;
            private String name;
            private String first_name;
            private String last_name;
            private String twitter_username;
            private Object portfolio_url;
            private Object bio;
            private String location;
            private LinksBeanX links;
            private ProfileImageBean profile_image;
            private String instagram_username;
            private int total_collections;
            private int total_likes;
            private int total_photos;
            private boolean accepted_tos;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getUpdated_at() {
                return updated_at;
            }

            public void setUpdated_at(String updated_at) {
                this.updated_at = updated_at;
            }

            public String getUsername() {
                return username;
            }

            public void setUsername(String username) {
                this.username = username;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getFirst_name() {
                return first_name;
            }

            public void setFirst_name(String first_name) {
                this.first_name = first_name;
            }

            public String getLast_name() {
                return last_name;
            }

            public void setLast_name(String last_name) {
                this.last_name = last_name;
            }

            public String getTwitter_username() {
                return twitter_username;
            }

            public void setTwitter_username(String twitter_username) {
                this.twitter_username = twitter_username;
            }

            public Object getPortfolio_url() {
                return portfolio_url;
            }

            public void setPortfolio_url(Object portfolio_url) {
                this.portfolio_url = portfolio_url;
            }

            public Object getBio() {
                return bio;
            }

            public void setBio(Object bio) {
                this.bio = bio;
            }

            public String getLocation() {
                return location;
            }

            public void setLocation(String location) {
                this.location = location;
            }

            public LinksBeanX getLinks() {
                return links;
            }

            public void setLinks(LinksBeanX links) {
                this.links = links;
            }

            public ProfileImageBean getProfile_image() {
                return profile_image;
            }

            public void setProfile_image(ProfileImageBean profile_image) {
                this.profile_image = profile_image;
            }

            public String getInstagram_username() {
                return instagram_username;
            }

            public void setInstagram_username(String instagram_username) {
                this.instagram_username = instagram_username;
            }

            public int getTotal_collections() {
                return total_collections;
            }

            public void setTotal_collections(int total_collections) {
                this.total_collections = total_collections;
            }

            public int getTotal_likes() {
                return total_likes;
            }

            public void setTotal_likes(int total_likes) {
                this.total_likes = total_likes;
            }

            public int getTotal_photos() {
                return total_photos;
            }

            public void setTotal_photos(int total_photos) {
                this.total_photos = total_photos;
            }

            public boolean isAccepted_tos() {
                return accepted_tos;
            }

            public void setAccepted_tos(boolean accepted_tos) {
                this.accepted_tos = accepted_tos;
            }

            public static class LinksBeanX {
                /**
                 * self : https://api.unsplash.com/users/chrisleeiam
                 * html : https://unsplash.com/@chrisleeiam
                 * photos : https://api.unsplash.com/users/chrisleeiam/photos
                 * likes : https://api.unsplash.com/users/chrisleeiam/likes
                 * portfolio : https://api.unsplash.com/users/chrisleeiam/portfolio
                 * following : https://api.unsplash.com/users/chrisleeiam/following
                 * followers : https://api.unsplash.com/users/chrisleeiam/followers
                 */

                private String self;
                private String html;
                private String photos;
                private String likes;
                private String portfolio;
                private String following;
                private String followers;

                public String getSelf() {
                    return self;
                }

                public void setSelf(String self) {
                    this.self = self;
                }

                public String getHtml() {
                    return html;
                }

                public void setHtml(String html) {
                    this.html = html;
                }

                public String getPhotos() {
                    return photos;
                }

                public void setPhotos(String photos) {
                    this.photos = photos;
                }

                public String getLikes() {
                    return likes;
                }

                public void setLikes(String likes) {
                    this.likes = likes;
                }

                public String getPortfolio() {
                    return portfolio;
                }

                public void setPortfolio(String portfolio) {
                    this.portfolio = portfolio;
                }

                public String getFollowing() {
                    return following;
                }

                public void setFollowing(String following) {
                    this.following = following;
                }

                public String getFollowers() {
                    return followers;
                }

                public void setFollowers(String followers) {
                    this.followers = followers;
                }
            }

            public static class ProfileImageBean {
                /**
                 * small : https://images.unsplash.com/profile-1444150880999-8042a8ce0979?ixlib=rb-0.3.5&q=80&fm=jpg&crop=faces&cs=tinysrgb&fit=crop&h=32&w=32&s=a19248eb27010a89557b8976bc63dbbc
                 * medium : https://images.unsplash.com/profile-1444150880999-8042a8ce0979?ixlib=rb-0.3.5&q=80&fm=jpg&crop=faces&cs=tinysrgb&fit=crop&h=64&w=64&s=f0c7f03e3eb53cf672e41335d1ae78b5
                 * large : https://images.unsplash.com/profile-1444150880999-8042a8ce0979?ixlib=rb-0.3.5&q=80&fm=jpg&crop=faces&cs=tinysrgb&fit=crop&h=128&w=128&s=0e5c358a66770755f016bca86f02886c
                 */

                private String small;
                private String medium;
                private String large;

                public String getSmall() {
                    return small;
                }

                public void setSmall(String small) {
                    this.small = small;
                }

                public String getMedium() {
                    return medium;
                }

                public void setMedium(String medium) {
                    this.medium = medium;
                }

                public String getLarge() {
                    return large;
                }

                public void setLarge(String large) {
                    this.large = large;
                }
            }
        }

        public static class TagsBean {
            /**
             * title : greem
             */

            private String title;

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }
        }

        public static class PhotoTagsBean {
            /**
             * title : greem
             */

            private String title;

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }
        }
    }
}

