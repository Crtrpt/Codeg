var route = [
  {
    path: "/",
    component: () => import("../layout/Master.vue"),
    redirect :"/home",
    children: [
      {
        name: "home",
        path: "/home",
        component: () => import("../layout/Home.vue"),
      },
    ],
  },
  {
    path: "/auth",
    component: () => import("../layout/PageLayout.vue"),
    children: [
      {
        name: "login",
        path: "login",
        component: () => import("../pages/auth/Auth.vue"),
      },
      {
        name: "signup",
        path: "signup",
        component: () => import("../pages/auth/Signup.vue"),
      },
      {
        name: "found",
        path: "found",
        component: () => import("../pages/auth/Found.vue"),
      },
    ]
  },
  
];
export default route;
