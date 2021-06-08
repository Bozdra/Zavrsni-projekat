package constants;

public class Constants {
// Login
public static final String HOME_URL = "https://www.humanity.com/";
public static final String ABOUT_URL = "https://www.humanity.com/about";
public static final String ALLSTAFF_URL = "https://misternobody.humanity.com/app/staff/list/load/";
public static final String DASHBOARD_URL = "https://misternobody.humanity.com/app/dashboard/";
public static final String ABOUTBTN_XPATH = "//*[@id=\"wrapper\"]/footer/div[2]/div/div/div[1]/div[5]/ul/li[1]/a";
public static final String CLOSEMSSGBTN_XPATH = "//*[@id=\"tcp-modal\"]/div/div/div[1]/button";
public static final String CLOSECOOKIEMSG_XPATH = "//*[@id=\"cf-root\"]/div/div/div/div[2]/div[2]/div[2]/button";
public static final String LOGINPAGEBTN_XPATH = "//*[@id=\"navbarSupportedContent\"]/div/a[2]";
public static final String EMAILBAR_ID = "email";
public static final String LOGINBTN_XPATH = "//*[@id=\"LoginForm\"]/div[3]/div/button[1]";
// DashBoard 
public static final String DASHBOARD_XPATH = "//*[@id=\"_topnav\"]";
public static final String DASHBOARDBTN_XPATH = "//*[@id=\"topMenu\"]/li[1]";
public static final String SHIFTPLANNINGBTN_XPATH = "//*[@id=\"topMenu\"]/li[2]";
public static final String TIMECLOCKBTN_XPATH = "//*[@id=\"topMenu\"]/li[3]";
public static final String LEAVEBTN_XPATH = "//*[@id=\"sn_requests\"]/span";
public static final String TRAININGBTN_XPATH = "//*[@id=\"sn_training\"]/span";
public static final String STAFFBTN_XPATH = "//*[@id=\"sn_staff\"]/span";
public static final String AVAILABILITYBTN_ID = "sn_availability";
public static final String PAYROLLBTN_XPATH = "//*[@id=\"root\"]/div[2]/div/div/div[1]/div/div/div[2]/div[8]/a";
public static final String REPORTSBTN_XPATH = "//*[@id=\"sn_reports\"]/span";
public static final String SETTINGSBTN_XPATH = "//*[@id=\"sn_admin\"]/span";
public static final String LOGO_XPATH = "//*[@id=\"_nav\"]/div[1]";
public static final String AVAILAIBLITYCELL_XPATH = "//*[@id=\"EmployeeStaffFilter\"]";

// Page titles
public static final String DASHBOARD_TITLE = "Dashboard - Dashboard - Humanity";
public static final String SHIFTPLANNING_TITLE = "ShiftPlanning - Humanity";
public static final String TIMECLOCK_TITLE = "Timeclock - Overview - Humanity";
public static final String LEAVE_TITLE = "Leave - Vacation - Humanity";
public static final String TRAINING_TITLE = "Training - Overview - Humanity";
public static final String STAFF_TITLE = "Staff - Humanity";
public static final String AVAILABILITY_TITLE = "Humanity";
public static final String PAYROLL_TITLE =  "Payroll - Scheduled-hours - Humanity";
public static final String REPORT_TITLE = "Reports - Reports Home - Humanity";
public static final String SETTINGS_TITLE = "Settings - Manage Settings - Humanity";

// Staff
public static final String ADDEMPLOYEEBTNBTN_XPATH = "//*[@id=\"act_primary\"]";
public static final String FIRSTNAMEBAR_XPATH = "//*[@id=\"_asf1\"]";
public static final String LASTNAMEBAR_XPATH = "//*[@id=\"_asl1\"]";
public static final String EMAILBARSTAFF_XPATH = "//*[@id=\"_ase1\"]";
public static final String FIRSTNAMEBAR_ID = "_asf";
public static final String LASTNAMEBAR_ID = "_asl";
public static final String EMAILBARSTAFF_ID = "_ase";

public static final String SAVEEMPLOYEESBTN_ID = "_as_save_multiple";
public static final String EMPLOYEENAMECHECK_XPATH = "//*[@id=\"_cd_staff\"]/div[2]/div[2]/table/tbody/tr/td[2]/div[2]/div/table/tbody/tr[3]/td[1]";
public static final String SLCTEMP_XPATH = "//*[@id=\"7\"]/a";
public static final String SLCTALLSTAFF_XPATH = "//*[@id=\"StaffSchedules\"]/ul[1]/li[1]/a";
public static final String EMPLOYEEEMAIL_ID = "10";
public static final String EMPLOYEENAME_XPATH = "//*[@id=\"7\"]/a";
public static final String EMPEDITDETBTN_XPATH = "//*[@id=\"_cd_staff\"]/div[2]/div[2]/div[1]/a[2]";
public static final String CHANGEFNAMEBTN_ID = "first_name";
public static final String SAVEEMPLOYEEBTN_NAME = "dia_submit";
public static final String UPLOADPICBTN_ID = "fileupload";
public static final String UPLOADCONFIRM_XPATH = "//*[@id=\"fileupload_completedMessage\"]";
public static final String PIC_PATH = "https://s3.us-east-1.amazonaws.com/uf.shiftplanning.com/avatars/small_6370948-63709481623142891.jpg?1623142892116";
public static final String PIC_XPATH = "//*[@id=\"userAvatarWrapper\"]";

// Settings 
public static final String CHOOSELANGBAR_XPATH = "//*[@id=\"adminSettingsForm\"]/div[1]/table/tbody/tr[3]/td[2]/select";
public static final String CHOOSESERBIAN_XPATH = "//*[@id=\"adminSettingsForm\"]/div[1]/table/tbody/tr[3]/td[2]/select/option[37]";
public static final String SAVECHANGESBTN_XPATH = "//*[@id=\"act_primary\"]";
public static final String CHANGELANGCONFIRMMSG_XPATH = "//*[@id=\"_status\"]";
public static final String EMAILCHECKBOX_XPATH = "//*[@id=\"pref_pref_email\"]";
public static final String SMSCHECKBOX_XPATH = "//*[@id=\"pref_pref_sms\"]";
public static final String MOBILEPUSHCHECKBOX_XPATH = "//*[@id=\"pref_pref_mobile_push\"]";
public static final String ACCOUNTARROW_XPATH = "//*[@id=\"wrap_us_menu\"]/i";
public static final String ACCOUNTSETTINGS_XPATH = "//*[@id=\"userm\"]/div/a[2]";
public static final String ACCOUNTWORKID_ID = "eid";
public static final String ACCOUNTPHONE1_ID = "home[0]";
public static final String ACCOUNTPHONE2_ID = "home[1]";
public static final String ACCOUNTPHONE3_ID = "home[2]";
public static final String CHECKACCWORKID_XPATH = "//*[@id=\"_cd_staff\"]/div[2]/div[2]/div[2]/table/tbody/tr/td[1]/div[1]/ul/li[2]/span[2]";
public static final String CHECKHOMENUM_XPATH = "//*[@id=\"_cd_staff\"]/div[2]/div[2]/div[2]/table/tbody/tr/td[1]/div[1]/ul/li[4]/span[2]";
public static final String CHECKEMPLOYEE_XPATH = "//*[@id=\"_cd_staff\"]/div[2]/div[2]/div[1]/a[1]";
}
